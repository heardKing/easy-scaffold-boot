DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
)COMMENT='管理员表';

DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) COMMENT='部门表';

delete from sys_dept;

INSERT INTO `sys_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `sys_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `sys_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `sys_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);


DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
)COMMENT='角色表';

delete from sys_role;

INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);

DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
)COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('3377', '105', '5');
INSERT INTO `sys_relation` VALUES ('3378', '106', '5');
INSERT INTO `sys_relation` VALUES ('3379', '107', '5');
INSERT INTO `sys_relation` VALUES ('3380', '108', '5');
INSERT INTO `sys_relation` VALUES ('3381', '109', '5');
INSERT INTO `sys_relation` VALUES ('3382', '110', '5');
INSERT INTO `sys_relation` VALUES ('3383', '111', '5');
INSERT INTO `sys_relation` VALUES ('3384', '112', '5');
INSERT INTO `sys_relation` VALUES ('3385', '113', '5');
INSERT INTO `sys_relation` VALUES ('3386', '114', '5');
INSERT INTO `sys_relation` VALUES ('3387', '115', '5');
INSERT INTO `sys_relation` VALUES ('3388', '116', '5');
INSERT INTO `sys_relation` VALUES ('3389', '117', '5');
INSERT INTO `sys_relation` VALUES ('3390', '118', '5');
INSERT INTO `sys_relation` VALUES ('3391', '119', '5');
INSERT INTO `sys_relation` VALUES ('3392', '120', '5');
INSERT INTO `sys_relation` VALUES ('3393', '121', '5');
INSERT INTO `sys_relation` VALUES ('3394', '122', '5');
INSERT INTO `sys_relation` VALUES ('3395', '150', '5');
INSERT INTO `sys_relation` VALUES ('3396', '151', '5');
INSERT INTO `sys_relation` VALUES ('3737', '105', '1');
INSERT INTO `sys_relation` VALUES ('3738', '106', '1');
INSERT INTO `sys_relation` VALUES ('3739', '107', '1');
INSERT INTO `sys_relation` VALUES ('3740', '108', '1');
INSERT INTO `sys_relation` VALUES ('3741', '109', '1');
INSERT INTO `sys_relation` VALUES ('3742', '110', '1');
INSERT INTO `sys_relation` VALUES ('3743', '111', '1');
INSERT INTO `sys_relation` VALUES ('3744', '112', '1');
INSERT INTO `sys_relation` VALUES ('3745', '113', '1');
INSERT INTO `sys_relation` VALUES ('3746', '165', '1');
INSERT INTO `sys_relation` VALUES ('3747', '166', '1');
INSERT INTO `sys_relation` VALUES ('3748', '167', '1');
INSERT INTO `sys_relation` VALUES ('3749', '114', '1');
INSERT INTO `sys_relation` VALUES ('3750', '115', '1');
INSERT INTO `sys_relation` VALUES ('3751', '116', '1');
INSERT INTO `sys_relation` VALUES ('3752', '117', '1');
INSERT INTO `sys_relation` VALUES ('3753', '118', '1');
INSERT INTO `sys_relation` VALUES ('3754', '162', '1');
INSERT INTO `sys_relation` VALUES ('3755', '163', '1');
INSERT INTO `sys_relation` VALUES ('3756', '164', '1');
INSERT INTO `sys_relation` VALUES ('3757', '119', '1');
INSERT INTO `sys_relation` VALUES ('3758', '120', '1');
INSERT INTO `sys_relation` VALUES ('3759', '121', '1');
INSERT INTO `sys_relation` VALUES ('3760', '122', '1');
INSERT INTO `sys_relation` VALUES ('3761', '150', '1');
INSERT INTO `sys_relation` VALUES ('3762', '151', '1');
INSERT INTO `sys_relation` VALUES ('3763', '128', '1');
INSERT INTO `sys_relation` VALUES ('3764', '134', '1');
INSERT INTO `sys_relation` VALUES ('3765', '158', '1');
INSERT INTO `sys_relation` VALUES ('3766', '159', '1');
INSERT INTO `sys_relation` VALUES ('3767', '130', '1');
INSERT INTO `sys_relation` VALUES ('3768', '131', '1');
INSERT INTO `sys_relation` VALUES ('3769', '135', '1');
INSERT INTO `sys_relation` VALUES ('3770', '136', '1');
INSERT INTO `sys_relation` VALUES ('3771', '137', '1');
INSERT INTO `sys_relation` VALUES ('3772', '152', '1');
INSERT INTO `sys_relation` VALUES ('3773', '153', '1');
INSERT INTO `sys_relation` VALUES ('3774', '154', '1');
INSERT INTO `sys_relation` VALUES ('3775', '132', '1');
INSERT INTO `sys_relation` VALUES ('3776', '138', '1');
INSERT INTO `sys_relation` VALUES ('3777', '139', '1');
INSERT INTO `sys_relation` VALUES ('3778', '140', '1');
INSERT INTO `sys_relation` VALUES ('3779', '155', '1');
INSERT INTO `sys_relation` VALUES ('3780', '156', '1');
INSERT INTO `sys_relation` VALUES ('3781', '157', '1');
INSERT INTO `sys_relation` VALUES ('3782', '133', '1');
INSERT INTO `sys_relation` VALUES ('3783', '160', '1');
INSERT INTO `sys_relation` VALUES ('3784', '161', '1');
INSERT INTO `sys_relation` VALUES ('3785', '141', '1');
INSERT INTO `sys_relation` VALUES ('3786', '142', '1');
INSERT INTO `sys_relation` VALUES ('3787', '143', '1');
INSERT INTO `sys_relation` VALUES ('3788', '144', '1');
INSERT INTO `sys_relation` VALUES ('3789', '145', '1');
INSERT INTO `sys_relation` VALUES ('3790', '148', '1');
INSERT INTO `sys_relation` VALUES ('3791', '149', '1');
