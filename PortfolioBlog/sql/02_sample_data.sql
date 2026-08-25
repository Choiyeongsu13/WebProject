/* ============================================================================
   PortfolioBlog - 샘플 데이터
   ----------------------------------------------------------------------------
   지금 JSP 에 하드코딩되어 있는 더미 내용을 그대로 옮겼습니다.
   DAO 를 만들 때 이 데이터로 조회가 되는지 확인하면 됩니다.
   [  ] 로 되어 있는 부분은 실제 값으로 바꿔주세요.
   ============================================================================ */


/* ---------------------------------------------------------------- 관리자 */
INSERT INTO blog_user (login_id, password, name, email)
VALUES ('admin', '[해시값으로_교체]', '최영수', 'choiyeongsu0813@gmail.com');


/* ---------------------------------------------------------------- 카테고리 */
INSERT INTO category (code, name_ko, name_ja, sort_order)
VALUES ('TECH', '기술', '技術', 1);

INSERT INTO category (code, name_ko, name_ja, sort_order)
VALUES ('TRAVEL', '여행', '旅行', 2);

INSERT INTO category (code, name_ko, name_ja, sort_order)
VALUES ('DAILY', '일상', '日常', 3);


/* ---------------------------------------------------------------- 태그 */
INSERT INTO tag (name) VALUES ('JSP');
INSERT INTO tag (name) VALUES ('Servlet');
INSERT INTO tag (name) VALUES ('Oracle');
INSERT INTO tag (name) VALUES ('MVC');
INSERT INTO tag (name) VALUES ('DAO');
INSERT INTO tag (name) VALUES ('Java');
INSERT INTO tag (name) VALUES ('Android');
INSERT INTO tag (name) VALUES ('일본');


/* ---------------------------------------------------------------- 글 */
INSERT INTO post (category_id, title, slug, summary, content,
                  read_minutes, status, published_at)
VALUES ((SELECT category_id FROM category WHERE code = 'TECH'),
        'JSP 프로젝트에서 DAO 패턴 정리하기',
        'jsp-dao-pattern',
        '학과 팀 프로젝트에서 JSP 안에 SQL 이 그대로 들어가 있던 코드를 DAO 로 분리한 과정을 정리했습니다.',
        '학과 팀 프로젝트를 진행하면서 JSP 안에 SQL 이 그대로 들어가 있는 코드를 마주쳤습니다. 이 글에서는 그 코드를 DAO 로 분리한 과정을 정리해봅니다.',
        6, 'PUBLISHED', TO_DATE('2026-08-15', 'YYYY-MM-DD'));

INSERT INTO post (category_id, title, slug, summary, content,
                  read_minutes, status, published_at)
VALUES ((SELECT category_id FROM category WHERE code = 'TECH'),
        'Oracle 연동하며 겪은 커넥션 관리 문제',
        'oracle-connection-management',
        'close() 를 빠뜨려 커넥션이 새던 문제를 try-with-resources 로 해결한 기록입니다.',
        'JDBC 로 Oracle 을 붙이면서 커넥션을 닫지 않아 생긴 문제와 해결 과정을 정리했습니다.',
        4, 'PUBLISHED', TO_DATE('2026-07-28', 'YYYY-MM-DD'));

INSERT INTO post (category_id, title, slug, summary, content,
                  read_minutes, status, published_at)
VALUES ((SELECT category_id FROM category WHERE code = 'TRAVEL'),
        '오사카에서 보낸 나흘, 여행 기록',
        'osaka-four-days',
        '오사카에서 보낸 나흘간의 기록입니다.',
        '오사카 여행에서 찍은 사진과 다녀온 곳들을 정리했습니다.',
        NULL, 'PUBLISHED', TO_DATE('2026-07-22', 'YYYY-MM-DD'));

INSERT INTO post (category_id, title, slug, summary, content,
                  read_minutes, status, published_at)
VALUES ((SELECT category_id FROM category WHERE code = 'TRAVEL'),
        '종강 후 떠난 교토 벚꽃 산책',
        'kyoto-cherry-blossom',
        '종강하자마자 떠난 교토 벚꽃 여행 기록입니다.',
        '교토에서 벚꽃을 보며 걸었던 길들을 사진과 함께 남깁니다.',
        NULL, 'PUBLISHED', TO_DATE('2026-04-05', 'YYYY-MM-DD'));


/* ---------------------------------------------------------------- 글-태그 연결 */
INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'jsp-dao-pattern'),
        (SELECT tag_id  FROM tag  WHERE name = 'JSP'));;

INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'jsp-dao-pattern'),
        (SELECT tag_id  FROM tag  WHERE name = 'Oracle'));;

INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'jsp-dao-pattern'),
        (SELECT tag_id  FROM tag  WHERE name = 'DAO'));;

INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'oracle-connection-management'),
        (SELECT tag_id  FROM tag  WHERE name = 'Oracle'));;

INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'osaka-four-days'),
        (SELECT tag_id  FROM tag  WHERE name = '일본'));;

INSERT INTO post_tag (post_id, tag_id)
VALUES ((SELECT post_id FROM post WHERE slug = 'kyoto-cherry-blossom'),
        (SELECT tag_id  FROM tag  WHERE name = '일본'));;


/* ---------------------------------------------------------------- 프로젝트 */
INSERT INTO project (title, subtitle, description, category_code,
                     github_url, demo_url, team_size, my_role, is_featured, sort_order)
VALUES ('[프로젝트명]', '학과 팀 프로젝트',
        'JSP 와 Oracle 로 만든 학내 커뮤니티 서비스입니다. 4인 팀에서 화면 개발을 담당했습니다.',
        'WEB',
        'https://github.com/Choiyeongsu13/[저장소명]', NULL,
        4, '프론트엔드 화면 개발 및 게시판 CRUD', 'Y', 1);

INSERT INTO project (title, subtitle, description, category_code,
                     github_url, demo_url, team_size, my_role, is_featured, sort_order)
VALUES ('[프로젝트명]', '선거 결과 조회',
        'Model2 MVC 패턴으로 구현한 선거 데이터 조회 웹 애플리케이션입니다.',
        'WEB',
        'https://github.com/Choiyeongsu13/WebProject', NULL,
        1, '전체 설계 및 구현', 'Y', 2);

INSERT INTO project (title, subtitle, description, category_code,
                     github_url, demo_url, team_size, my_role, is_featured, sort_order)
VALUES ('[프로젝트명]', '데이터 분석 과제',
        '백신 접종 데이터를 조회하고 통계를 시각화한 프로젝트입니다.',
        'DATA',
        'https://github.com/Choiyeongsu13/WebProject', NULL,
        1, '전체 설계 및 구현', 'N', 3);

INSERT INTO project (title, subtitle, description, category_code,
                     github_url, demo_url, team_size, my_role, is_featured, sort_order)
VALUES ('[프로젝트명]', '캡스톤 디자인',
        '캠퍼스 길찾기 앱입니다. 팀 발표에서 좋은 평가를 받았습니다.',
        'MOBILE',
        NULL, NULL,
        4, '[담당 역할]', 'N', 4);

INSERT INTO project (title, subtitle, description, category_code,
                     github_url, demo_url, team_size, my_role, is_featured, sort_order)
VALUES ('포트폴리오 블로그', '개인 사이드 프로젝트',
        '지금 보고 계신 이 포트폴리오 사이트를 직접 설계하고 구현했습니다.',
        'WEB',
        'https://github.com/Choiyeongsu13/[저장소명]', NULL,
        1, '기획 · 화면 설계 · DB 설계 · 구현 전체', 'Y', 5);


/* ---------------------------------------------------------------- 프로젝트-태그 연결 */
INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 1),
        (SELECT tag_id FROM tag WHERE name = 'JSP'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 1),
        (SELECT tag_id FROM tag WHERE name = 'Oracle'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 2),
        (SELECT tag_id FROM tag WHERE name = 'Servlet'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 2),
        (SELECT tag_id FROM tag WHERE name = 'MVC'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 3),
        (SELECT tag_id FROM tag WHERE name = 'Java'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 3),
        (SELECT tag_id FROM tag WHERE name = 'Oracle'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 4),
        (SELECT tag_id FROM tag WHERE name = 'Android'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 4),
        (SELECT tag_id FROM tag WHERE name = 'Java'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 5),
        (SELECT tag_id FROM tag WHERE name = 'JSP'));;

INSERT INTO project_tag (project_id, tag_id)
VALUES ((SELECT project_id FROM project WHERE sort_order = 5),
        (SELECT tag_id FROM tag WHERE name = 'MVC'));;


/* ---------------------------------------------------------------- 여행 앨범 */
INSERT INTO album (title, place, country, description,
                   travel_from, travel_to, latitude, longitude, post_id)
VALUES ('오사카 나흘', '오사카', '일본',
        '오사카에서 보낸 나흘간의 사진들입니다.',
        TO_DATE('2026-07-18', 'YYYY-MM-DD'),
        TO_DATE('2026-07-21', 'YYYY-MM-DD'),
        34.669529, 135.501651,
        (SELECT post_id FROM post WHERE slug = 'osaka-four-days'));

INSERT INTO album (title, place, country, description,
                   travel_from, travel_to, latitude, longitude, post_id)
VALUES ('교토 벚꽃', '교토', '일본',
        '종강 후 떠난 교토 벚꽃 산책.',
        TO_DATE('2026-04-02', 'YYYY-MM-DD'),
        TO_DATE('2026-04-04', 'YYYY-MM-DD'),
        35.011636, 135.768029,
        (SELECT post_id FROM post WHERE slug = 'kyoto-cherry-blossom'));


/* ---------------------------------------------------------------- 사진 */
INSERT INTO photo (album_id, file_name, caption, taken_at, is_cover, sort_order)
VALUES ((SELECT album_id FROM album WHERE title = '오사카 나흘'),
        'osaka-01.jpg', '도톤보리의 밤', TO_DATE('2026-07-18', 'YYYY-MM-DD'), 'Y', 1);

INSERT INTO photo (album_id, file_name, caption, taken_at, is_cover, sort_order)
VALUES ((SELECT album_id FROM album WHERE title = '오사카 나흘'),
        'osaka-02.jpg', '오사카성 가는 길', TO_DATE('2026-07-19', 'YYYY-MM-DD'), 'N', 2);

INSERT INTO photo (album_id, file_name, caption, taken_at, is_cover, sort_order)
VALUES ((SELECT album_id FROM album WHERE title = '교토 벚꽃'),
        'kyoto-01.jpg', '철학의 길', TO_DATE('2026-04-03', 'YYYY-MM-DD'), 'Y', 1);


/* ---------------------------------------------------------------- 댓글 */
INSERT INTO post_comment (post_id, parent_id, nickname, password, content)
VALUES ((SELECT post_id FROM post WHERE slug = 'jsp-dao-pattern'),
        NULL, '지나가던개발자', '[해시값으로_교체]',
        'try-with-resources 부분 도움 많이 됐습니다. 저도 예전에 커넥션 안 닫아서 고생했네요.');

INSERT INTO post_comment (post_id, parent_id, nickname, password, content)
VALUES ((SELECT post_id FROM post WHERE slug = 'jsp-dao-pattern'),
        (SELECT MAX(comment_id) FROM post_comment), '최영수', '[해시값으로_교체]',
        '읽어주셔서 감사합니다. ROWNUM 쪽도 한참 헤맸어요.');

INSERT INTO post_comment (post_id, parent_id, nickname, password, content)
VALUES ((SELECT post_id FROM post WHERE slug = 'osaka-four-days'),
        NULL, 'travel_lover', '[해시값으로_교체]',
        '사진 분위기가 좋네요. 도톤보리는 밤에 가는 게 확실히 예쁜 것 같아요.');

COMMIT;
