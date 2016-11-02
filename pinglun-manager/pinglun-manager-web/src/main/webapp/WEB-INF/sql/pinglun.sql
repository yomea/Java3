use pinglun

Create Table: CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL,
  `user_pic` varchar(1024) DEFAULT 'http://img1.gamedog.cn/2012/04/11/6-120411163958.jpg',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT '用户表';

Create Table: CREATE TABLE `tb_shuoshuo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` text COMMENT '说说内容',
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Create Table: CREATE TABLE `tb_pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shuoshuo_id` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;