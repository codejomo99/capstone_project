-- 사용자 데이터
INSERT INTO users (email, password, name, department, student_id)
VALUES
    ('user1@example.com', 'password1', 'User 1', 'COMPUTER_ENGINEERING', 'ID_19'),
    ('user2@example.com', 'password2', 'User 2', 'ELECTRICAL_ENGINEERING', 'ID_20'),
    ('user3@example.com', 'password3', 'User 3', 'BUSINESS_ADMINISTRATION', 'ID_21');

-- 게시판 데이터
INSERT INTO board (name, description)
VALUES
    ('게시판 제목1', '게시판 내용1'),
    ('게시판 제목2', '게시판 내용2'),
    ('게시판 제목3', '게시판 내용3');

-- 게시물 데이터
INSERT INTO post (title, content, like_count, search_allowed, comment_allowed, department, student_id, user_id, board_id)
VALUES
    ('게시물 제목1', '게시물 내용1', 0, true, true, 'COMPUTER_ENGINEERING', 'ID_19', 1, 1),
    ('게시물 제목2', '게시물 내용2', 0, true, true, 'ELECTRICAL_ENGINEERING', 'ID_20', 2, 2),
    ('게시물 제목3', '게시물 내용3', 0, true, true, 'BUSINESS_ADMINISTRATION', 'ID_21', 3, 3);

-- 댓글 데이터
INSERT INTO comment (user_id, post_id, content)
VALUES
    (1, 1, '부모 댓글 내용 1'),
    (2, 2, '부모 댓글 내용 2'),
    (3, 3, '부모 댓글 내용 3');

-- 대댓글 데이터
INSERT INTO comment (user_id, post_id, parent_comment_id, content)
VALUES
    (2, 1, 1, '대댓글 내용 1'),
    (3, 1, 1, '대댓글 내용 2'),
    (1, 2, 2, '대댓글 내용 3'),
    (3, 2, 2, '대댓글 내용 4'),
    (1, 3, 3, '대댓글 내용 5'),
    (2, 3, 3, '대댓글 내용 6');

