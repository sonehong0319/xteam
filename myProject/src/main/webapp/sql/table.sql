create table member(
  mem_num number not null,
  mem_id varchar2(12) unique not null,
  mem_auth number(1) default 2 not null,/*0탈퇴회원,1정지회원,2일반회원,3관리자*/
  constraint member_pk primary key (mem_num)
);

create table member_detail(
  mem_num number not null,
  mem_name varchar2(30) not null,
  mem_passwd varchar2(35) not null,
  mem_phone varchar2(15) not null,
  mem_email varchar2(50) not null,
  mem_photo blob,
  mem_photoname varchar2(100),
  reg_date date default sysdate not null,
  constraint member_detail_pk primary key (mem_num),
  constraint member_detail_fk foreign key (mem_num) references member (mem_num)
);
create sequence member_seq;

create table games(
  gam_num number not null,
  gam_name varchar2(30) not null,
  gam_price number(30) not null,
  gam_date date,
  gam_hit number,
  gam_detail clob not null,
  gam_uploadfile blob,
  cate_num number,
  constraint games_pk primary key (gam_num),
  constraint games_fk foreign key (cate_num) references category (cate_num)
);
create sequence games_seq;

create table category(
  cate_num number not null,
  cate_name varchar2(30) not null,
  constraint category_pk primary key (cate_num)
);

create table gamecate_matching(
  mat_num number not null,
  gam_num number not null,
  cate_num number not null,
  constraint gamecate_matching_pk primary key (mat_num),
  constraint gamecate_matching_fk foreign key (gam_num) references games (gam_num) 
  constraint gamecate_matching_fk1 foreign key (cate_num) references category (cate_num)
);

create table purchase(
  pur_num number not null,
  mem_num number not null,
  gam_num number not null,
  pur_date date not null,
  constraint purchase_pk primary key (pur_num),
  constraint purchase_fk foreign key (mem_num) references member (mem_num),
  constraint purchase_fk1 foreign key (gam_num) references games (gam_num)
);
create sequence purchase_seq;

create table board(
  board_num number not null,
  board_title varchar2(100) not null,
  board_content clob not null,
  board_hit number(5) default 0 not null,
  board_reg_date date default sysdate not null,
  board_modify_date date default sysdate not null,
  board_uploadfile blob,
  board_filename varchar2(100),
  mem_num number not null,
  constraint board_pk primary key (board_num),
  constraint board_fk foreign key (mem_num) references member(mem_num)
);
create sequence board_seq;

create table comments(
  com_num number not null,
  mem_id varchar2(12) not null,
  com_content clob not null,
  board_num number not null,
  constraint comment_pk primary key (com_num),
  constraint comment_fk foreign key (mem_id) references member(mem_id),
  constraint comment_fk1 foreign key (board_num) references board(board_num)
);


create table wishlist(
  wish_num number not null,
  mem_num number not null,
  gam_num number not null,
  constraint wishlist_pk primary key (wish_num),
  constraint wishlist_fk foreign key (mem_num) references member(mem_num),
  constraint wishlist_fk1 foreign key (gam_num) references games(gam_num)
);












