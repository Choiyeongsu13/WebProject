/* ============================================================================
   PortfolioBlog - 전체 삭제 스크립트
   ----------------------------------------------------------------------------
   테이블을 다시 만들고 싶을 때 먼저 실행합니다.
   외래키 때문에 자식 테이블부터 지워야 하므로 CASCADE CONSTRAINTS 를 붙였습니다.
   처음 실행하는 경우 "존재하지 않는 테이블" 오류가 나는데 무시하셔도 됩니다.

   IDENTITY 컬럼이 쓰는 시퀀스(ISEQ$$_xxxxx)는 테이블을 지우면 같이 사라집니다.
   따로 DROP SEQUENCE 를 할 필요가 없습니다.
   ============================================================================ */

DROP TABLE post_comment CASCADE CONSTRAINTS;
DROP TABLE photo       CASCADE CONSTRAINTS;
DROP TABLE album       CASCADE CONSTRAINTS;
DROP TABLE project_tag CASCADE CONSTRAINTS;
DROP TABLE project     CASCADE CONSTRAINTS;
DROP TABLE post_tag    CASCADE CONSTRAINTS;
DROP TABLE tag         CASCADE CONSTRAINTS;
DROP TABLE post        CASCADE CONSTRAINTS;
DROP TABLE category    CASCADE CONSTRAINTS;
DROP TABLE blog_user   CASCADE CONSTRAINTS;
