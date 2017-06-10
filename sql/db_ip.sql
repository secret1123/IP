DROP DATABASE IF EXISTS db_ip;
CREATE DATABASE db_ip;

DROP TABLE IF EXISTS db_ip.user;
CREATE TABLE db_ip.user (
  id  INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  min VARCHAR(255) COMMENT '起始IP地址',
  max VARCHAR(255) COMMENT '终止IP地址',
  geo VARCHAR(255) COMMENT '地理位置'
)
  COMMENT 'IP 表';

SELECT *
FROM db_ip.user;