/* ============================================================================
   PortfolioBlog - 화면별 조회 쿼리 모음
   ----------------------------------------------------------------------------
   DAO 를 만들 때 그대로 가져다 쓸 수 있게 화면 단위로 정리했습니다.
   ? 는 PreparedStatement 의 바인딩 자리입니다.
   ============================================================================ */


/* ---------------------------------------------------------------------------
   [index.jsp] 홈 - 대표 프로젝트 3건
   --------------------------------------------------------------------------- */
SELECT *
  FROM (SELECT p.project_id,
               p.title,
               p.subtitle,
               p.description,
               p.thumbnail
          FROM project p
         WHERE p.is_featured = 'Y'
         ORDER BY p.sort_order, p.project_id)
 WHERE ROWNUM <= 3;


/* ---------------------------------------------------------------------------
   [index.jsp] 홈 - 카테고리별 최근 글 2건
                     기술 박스와 여행 박스에서 code 만 바꿔 두 번 부릅니다.
   --------------------------------------------------------------------------- */
SELECT *
  FROM (SELECT p.post_id,
               p.title,
               p.slug,
               p.read_minutes,
               p.published_at
          FROM post p
          JOIN category c ON c.category_id = p.category_id
         WHERE p.status = 'PUBLISHED'
           AND c.code = ?                      -- 'TECH' 또는 'TRAVEL'
         ORDER BY p.published_at DESC)
 WHERE ROWNUM <= 2;


/* ---------------------------------------------------------------------------
   [projects.jsp] 프로젝트 목록 (필터 포함)
                  '전체' 일 때는 ? 에 NULL 을 넣으면 조건이 무시됩니다.
   --------------------------------------------------------------------------- */
SELECT p.project_id,
       p.title,
       p.subtitle,
       p.description,
       p.category_code,
       p.thumbnail,
       p.github_url,
       p.demo_url
  FROM project p
 WHERE (? IS NULL OR p.category_code = ?)      -- 같은 값을 두 번 바인딩
 ORDER BY p.sort_order, p.project_id;


/* ---------------------------------------------------------------------------
   프로젝트 카드에 붙일 기술 태그
   목록 조회 후 project_id 별로 한 번 더 부르거나, IN 절로 묶어서 씁니다.
   --------------------------------------------------------------------------- */
SELECT pt.project_id,
       t.name
  FROM project_tag pt
  JOIN tag t ON t.tag_id = pt.tag_id
 WHERE pt.project_id = ?
 ORDER BY t.name;


/* ---------------------------------------------------------------------------
   [post.jsp] 글 상세 - 본문
   --------------------------------------------------------------------------- */
SELECT p.post_id,
       p.title,
       p.summary,
       p.content,
       p.read_minutes,
       p.published_at,
       c.code    AS category_code,
       c.name_ko AS category_name
  FROM post p
  JOIN category c ON c.category_id = p.category_id
 WHERE p.slug = ?
   AND p.status = 'PUBLISHED';


/* ---------------------------------------------------------------------------
   [post.jsp] 글 상세 - 태그
   --------------------------------------------------------------------------- */
SELECT t.name
  FROM post_tag pt
  JOIN tag t ON t.tag_id = pt.tag_id
 WHERE pt.post_id = ?
 ORDER BY t.name;


/* ---------------------------------------------------------------------------
   [post.jsp] 글 상세 - 관련 글 (같은 카테고리의 다른 글 2건)
   --------------------------------------------------------------------------- */
SELECT *
  FROM (SELECT p.post_id,
               p.title,
               p.slug,
               p.published_at
          FROM post p
         WHERE p.category_id = ?
           AND p.post_id <> ?
           AND p.status = 'PUBLISHED'
         ORDER BY p.published_at DESC)
 WHERE ROWNUM <= 2;


/* ---------------------------------------------------------------------------
   조회수 1 증가 (글 상세를 열 때)
   --------------------------------------------------------------------------- */
UPDATE post
   SET view_count = view_count + 1
 WHERE post_id = ?;


/* ---------------------------------------------------------------------------
   블로그 목록 - 페이징
   Oracle 11g 이하에서 쓰는 3중 서브쿼리 방식입니다.
   ? 순서 : 끝행, 시작행
   (12c 이상이면 OFFSET ? ROWS FETCH NEXT ? ROWS ONLY 로 짧게 쓸 수 있습니다)
   --------------------------------------------------------------------------- */
SELECT *
  FROM (SELECT rownum AS rn, a.*
          FROM (SELECT p.post_id,
                       p.title,
                       p.slug,
                       p.summary,
                       p.published_at,
                       c.name_ko AS category_name
                  FROM post p
                  JOIN category c ON c.category_id = p.category_id
                 WHERE p.status = 'PUBLISHED'
                 ORDER BY p.published_at DESC) a
         WHERE rownum <= ?)
 WHERE rn > ?;


/* ---------------------------------------------------------------------------
   [여행 갤러리] 앨범 목록 + 대표 사진
   --------------------------------------------------------------------------- */
SELECT a.album_id,
       a.title,
       a.place,
       a.travel_from,
       a.travel_to,
       (SELECT ph.file_name
          FROM photo ph
         WHERE ph.album_id = a.album_id
           AND ph.is_cover = 'Y'
           AND rownum = 1) AS cover_file
  FROM album a
 ORDER BY a.travel_from DESC;


/* ---------------------------------------------------------------------------
   [여행 갤러리] 앨범 안의 사진들
   --------------------------------------------------------------------------- */
SELECT ph.photo_id,
       ph.file_name,
       ph.caption,
       ph.taken_at
  FROM photo ph
 WHERE ph.album_id = ?
 ORDER BY ph.sort_order, ph.photo_id;


/* ---------------------------------------------------------------------------
   [관리자] 글 등록
 
INSERT INTO post (category_id, title, slug, summary, content,
                  read_minutes, status, published_at)
VALUES (?, ?, ?, ?, ?, ?, 'PUBLISHED', SYSDATE);
  --------------------------------------------------------------------------- */

/* ---------------------------------------------------------------------------
   [관리자] 태그 연결
   태그가 이미 있으면 그대로 쓰고 없으면 새로 만드는 패턴입니다.
   --------------------------------------------------------------------------- */
MERGE INTO tag t
USING (SELECT ? AS name FROM dual) s
   ON (t.name = s.name)
 WHEN NOT MATCHED THEN
      INSERT (name) VALUES (s.name);

INSERT INTO post_tag (post_id, tag_id)
VALUES (?, (SELECT tag_id FROM tag WHERE name = ?));
