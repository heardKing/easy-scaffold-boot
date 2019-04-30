DELETE FROM user;

/*默认admin/123456*/
insert into `user`
(`id`, `username`, `email`, `mobile_phone_number`, `password`, `salt`, `create_date`, `status`, `admin`, `deleted`) values
  (1, 'admin', 'admin@sishuok.com', '13412345671', 'ec21fa1738f39d5312c6df46002d403d', 'yDd1956wn1', sysdate(), 'normal', 1, 0),
  (2, 'showcase', 'showcase@sishuok.com', '13412345672', '5f915c55c6d43da136a42e3ebabbecfc', 'hSSixwNQwt', sysdate(), 'normal', 1, 0),
  (3, 'sys', 'sys@sishuok.com', '13412345673', 'a10b3c7af051a81fe2506318f982ce28', 'MANHOoCpnb', sysdate(), 'normal', 1, 0),
  (4, 'maintain', 'maintain@sishuok.com', '13412345674', '594813c5eb02b210dacc1a36c2482fc1', 'iY71e4dtoa', sysdate(), 'normal', 1, 0),
  (5, 'create', 'create@sishuok.com', '13412345675', 'a6d5988a698dec63c6eea71994dd7be0', 'iruPxupgfb', sysdate(), 'normal', 1, 0),
  (6, 'update', 'update@sishuok.com', '13412345676', 'fffa26ac5c47ec1bf9a37d9823816074', '2WQx5LmvlV', sysdate(), 'normal', 1, 0),
  (7, 'delete', 'delete@sishuok.com', '13412345677', '4c472bf1d56f440d2953803ab4eea8d4', 'E8KSvr1C7d', sysdate(), 'normal', 1, 0),
  (8, 'view', 'view@sishuok.com', '13412345678', 'c919215efcef4064858bf02f8776c00d', 'XFJZQOXWZW', sysdate(), 'normal', 1, 0),
  (9, 'audit', 'audit@sishuok.com', '13412345679', '15d8f7b8da8045d24c71a92a142ffad7', 'BI2XbXMUr7', sysdate(), 'normal', 1, 0),
  (10, 'monitor', 'monitor@sishuok.com', '1341234580', 'e1549e68ad21fe888ae36ec4965116cd', 'iY71e4d123', sysdate(), 'normal', 1, 0);

