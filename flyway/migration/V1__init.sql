create table product_item (
    product_no int auto_increment comment '상품 번호'
        primary key,
    product_name varchar(50) not null comment '상품명',
    price int null comment '상품 가격',
    status_type char(8) not null comment '준비중/사용중/사용중지',
    register_ymdt datetime default CURRENT_TIMESTAMP not null comment '등록일',
    update_ymdt datetime null comment '수정일'
)
