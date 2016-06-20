/*
Navicat MySQL Data Transfer

Source Server         : bugqa
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : qasys

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-05-11 17:43:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_bug
-- ----------------------------
DROP TABLE IF EXISTS `tbl_bug`;
CREATE TABLE `tbl_bug` (
  `PROJECTID` varchar(40) NOT NULL DEFAULT '' COMMENT 'プロジェクトＩＤ',
  `BUGNO` varchar(15) NOT NULL DEFAULT '' COMMENT 'バグ番号',
  `SYSTEMTYPE` varchar(50) DEFAULT NULL COMMENT '機種/OS',
  `GROUPID` varchar(40) DEFAULT NULL COMMENT 'グループＩＤ',
  `MODULEID` varchar(40) DEFAULT NULL COMMENT 'モジュールＩＤ',
  `PRIORFLG` char(1) DEFAULT NULL COMMENT '優先フラグ',
  `COMPANYFLG` char(1) DEFAULT NULL COMMENT '社内フラグ',
  `BUGSTATE` char(1) DEFAULT NULL COMMENT 'バグ状態',
  `OCCURDATE` datetime DEFAULT NULL COMMENT '発生日',
  `TESTSPEC` varchar(50) DEFAULT NULL COMMENT 'テスト仕様書(機能名)',
  `STAGE` char(1) DEFAULT NULL COMMENT '摘出作業',
  `PHENOMENON` char(1) DEFAULT NULL COMMENT '現象',
  `BUGTYPE` char(1) DEFAULT NULL COMMENT '障害種別',
  `CONDDIV` char(1) DEFAULT NULL COMMENT '条件区分',
  `DETECTOR` varchar(16) DEFAULT NULL COMMENT '発行者',
  `DEVELOPER` varchar(16) DEFAULT NULL COMMENT '担当者',
  `PLNVERIFIER` varchar(16) DEFAULT NULL COMMENT '予定検証者',
  `VERIFIER` varchar(16) DEFAULT NULL COMMENT '検証者',
  `EXPDATE` datetime DEFAULT NULL COMMENT '希望日',
  `BUGINFO` text COMMENT '障害情報',
  `BUGINFO_CN` text COMMENT '障害情報（履歴）',
  `ATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '添付資料',
  `MODSTARTDATE` datetime DEFAULT NULL COMMENT '対応開始日付',
  `MODENDDATE` datetime DEFAULT NULL COMMENT '対応終了日付',
  `GENCAUSE` text COMMENT '原因概要',
  `GENCAUSE_CN` text COMMENT '原因概要（履歴）',
  `SOLVEMTD` text COMMENT '処置方法',
  `SOLVEMTD_CN` text COMMENT '処置方法（履歴）',
  `REPLIER` varchar(16) DEFAULT NULL COMMENT '回答者',
  `CONFIRMER` varchar(16) DEFAULT NULL COMMENT '確認者',
  `CORRPRONAME` text COMMENT '修正プログラム名',
  `CORRMODNAME` text COMMENT '修正モジュール名',
  `CAUSEDIV` char(2) DEFAULT NULL COMMENT '原因区分',
  `SPECCAUSEDIV` char(1) DEFAULT NULL COMMENT '原因細分',
  `SOLVEDIV` char(1) DEFAULT NULL COMMENT '処置区分',
  `VERIFYDATE` datetime DEFAULT NULL COMMENT '検証日',
  `REMARK` text COMMENT '備考',
  `REMARK_CN` text COMMENT '備考（履歴）',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  `EIKYOUDO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PROJECTID`,`BUGNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='バグ情報';

-- ----------------------------
-- Records of tbl_bug
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_bughistory
-- ----------------------------
DROP TABLE IF EXISTS `tbl_bughistory`;
CREATE TABLE `tbl_bughistory` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `BUGNO` varchar(15) NOT NULL COMMENT 'バグ番号',
  `SERIALNUM` varchar(5) NOT NULL COMMENT '連番',
  `SYSTEMTYPE` varchar(50) DEFAULT NULL COMMENT '機種/OS',
  `GROUPID` varchar(40) DEFAULT NULL COMMENT 'グループＩＤ',
  `MODULEID` varchar(40) DEFAULT NULL COMMENT 'モジュールＩＤ',
  `PRIORFLG` char(1) DEFAULT NULL COMMENT '優先フラグ',
  `COMPANYFLG` char(1) NOT NULL COMMENT '社内フラグ',
  `BUGSTATE` char(1) DEFAULT NULL COMMENT 'バグ状態',
  `OCCURDATE` datetime DEFAULT NULL COMMENT '発生日',
  `TESTSPEC` varchar(50) DEFAULT NULL COMMENT 'テスト仕様書(機能名)',
  `STAGE` char(1) DEFAULT NULL COMMENT '摘出作業',
  `PHENOMENON` char(1) DEFAULT NULL COMMENT '現象',
  `BUGTYPE` char(1) DEFAULT NULL COMMENT '障害種別',
  `CONDDIV` char(1) DEFAULT NULL COMMENT '条件区分',
  `DETECTOR` varchar(16) DEFAULT NULL COMMENT '発行者',
  `DEVELOPER` varchar(16) DEFAULT NULL COMMENT '担当者',
  `VERIFIER` varchar(16) DEFAULT NULL COMMENT '検証者',
  `PLNVERIFIER` varchar(16) DEFAULT NULL COMMENT '予定検証者',
  `EXPDATE` datetime DEFAULT NULL COMMENT '希望日',
  `BUGINFO` text COMMENT '障害情報',
  `BUGINFO_CN` text COMMENT '障害情報（履歴）',
  `ATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '添付資料',
  `PLNSTARTDATE` datetime DEFAULT NULL COMMENT '対応開始日付',
  `PLNENDDATE` datetime DEFAULT NULL COMMENT '対応終了日付',
  `GENCAUSE` text COMMENT '原因概要',
  `GENCAUSE_CN` text COMMENT '原因概要（履歴）',
  `SOLVEMTD` text COMMENT '処置方法',
  `SOLVEMTD_CN` text COMMENT '処置方法（履歴）',
  `REPLIER` varchar(16) DEFAULT NULL COMMENT '回答者',
  `REPLYDATE` datetime DEFAULT NULL COMMENT '回答日',
  `CONFIRMER` varchar(16) DEFAULT NULL COMMENT '確認者',
  `CORRPRONAME` text COMMENT '修正プログラム名',
  `CORRMODNAME` text COMMENT '修正モジュール名',
  `CAUSEDIV` char(1) DEFAULT NULL COMMENT '原因区分',
  `SPECCAUSEDIV` char(1) DEFAULT NULL COMMENT '原因細分',
  `SOLVEDIV` char(1) DEFAULT NULL COMMENT '処置区分',
  `VERIFYDATE` datetime DEFAULT NULL COMMENT '検証日',
  `REMARK` text COMMENT '備考',
  `REMARK_CN` text COMMENT '備考（履歴）',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  `RELATIONNO` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`PROJECTID`,`BUGNO`,`SERIALNUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='バグ情報履歴';

-- ----------------------------
-- Records of tbl_bughistory
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_classmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_classmaster`;
CREATE TABLE `tbl_classmaster` (
  `CUSTOMERCODE` varchar(6) NOT NULL COMMENT '得意先コード',
  `DEPARTMENTID` varchar(4) NOT NULL COMMENT '部門ＩＤ',
  `CLASSID` varchar(4) NOT NULL COMMENT '課ＩＤ',
  `CLASSNAME` varchar(40) NOT NULL COMMENT '課名称',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`CUSTOMERCODE`,`DEPARTMENTID`,`CLASSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='得意先課マスター ';

-- ----------------------------
-- Records of tbl_classmaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_customermaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customermaster`;
CREATE TABLE `tbl_customermaster` (
  `CUSTOMERCODE` varchar(6) NOT NULL COMMENT '得意先コード',
  `CUSTOMERNAME` varchar(50) NOT NULL COMMENT '得意先名称',
  `CUSTOMERNAMESUM` varchar(5) NOT NULL COMMENT '得意先略称',
  `COMPANYFLG` char(1) NOT NULL COMMENT '会社フラグ',
  `ZIPCODE` varchar(10) NOT NULL COMMENT '郵便番号',
  `ADDRESS` varchar(50) NOT NULL COMMENT '得意先住所',
  `PHONE` varchar(16) NOT NULL COMMENT '得意先電話',
  `FAX` varchar(16) NOT NULL COMMENT '得意先ファックス',
  `COMMENT` varchar(255) DEFAULT NULL COMMENT 'コメント',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`CUSTOMERCODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='得意先マスター';

-- ----------------------------
-- Records of tbl_customermaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_departmentmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_departmentmaster`;
CREATE TABLE `tbl_departmentmaster` (
  `CUSTOMERCODE` varchar(6) NOT NULL COMMENT '得意先コード',
  `DEPARTMENTID` varchar(4) NOT NULL COMMENT '部門ＩＤ',
  `DEPARTMENTNAME` varchar(40) NOT NULL COMMENT '部門名称',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`CUSTOMERCODE`,`DEPARTMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='得意先部門マスター';

-- ----------------------------
-- Records of tbl_departmentmaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_generalmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_generalmaster`;
CREATE TABLE `tbl_generalmaster` (
  `KBN` char(2) NOT NULL COMMENT '区分',
  `CODE` varchar(8) NOT NULL COMMENT 'コード',
  `NAME` varchar(50) NOT NULL COMMENT '名称',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`KBN`,`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='汎用マスター';

-- ----------------------------
-- Records of tbl_generalmaster
-- ----------------------------
INSERT INTO `tbl_generalmaster` VALUES ('01', '0', '摘出作業', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '1', '需求', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '2', '基本', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '3', '詳細', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '4', '製造', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '5', '単テ', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '6', '結合', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '7', '受入', '');
INSERT INTO `tbl_generalmaster` VALUES ('01', '8', 'システム', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '0', '職務表', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '1', 'プロジェクトマネージャー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '2', '概要設計メンバー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '3', 'プロジェクトリーダー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '4', 'DD詳細設計メンバー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '5', 'PGプログラマー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '6', 'UTテストメンバー', '');
INSERT INTO `tbl_generalmaster` VALUES ('02', '7', 'QA品質管理兼翻訳', '');
INSERT INTO `tbl_generalmaster` VALUES ('03', '0', '準備中', '');
INSERT INTO `tbl_generalmaster` VALUES ('03', '1', '開発中', '');
INSERT INTO `tbl_generalmaster` VALUES ('03', '2', '開発完了', '');
INSERT INTO `tbl_generalmaster` VALUES ('03', '3', 'キャンセル', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '1', '受領', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '2', '修正中', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '3', '修正済', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '4', '確認済', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '5', '検証済', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '6', '保留', '');
INSERT INTO `tbl_generalmaster` VALUES ('04', '7', 'キャンセル', '');
INSERT INTO `tbl_generalmaster` VALUES ('06', '1', '発行', '');
INSERT INTO `tbl_generalmaster` VALUES ('06', '2', '回答済', '');
INSERT INTO `tbl_generalmaster` VALUES ('06', '3', '承認済', '');
INSERT INTO `tbl_generalmaster` VALUES ('06', '4', '保留', '');
INSERT INTO `tbl_generalmaster` VALUES ('06', '5', 'キャンセル', '');
INSERT INTO `tbl_generalmaster` VALUES ('07', '1', '質問受付', '');
INSERT INTO `tbl_generalmaster` VALUES ('07', '2', '検討中', '');
INSERT INTO `tbl_generalmaster` VALUES ('07', '3', '回答済み', '');
INSERT INTO `tbl_generalmaster` VALUES ('07', '4', '移管', '');
INSERT INTO `tbl_generalmaster` VALUES ('07', '5', '他部署対応', '');
INSERT INTO `tbl_generalmaster` VALUES ('BT', '1', '新規', '');
INSERT INTO `tbl_generalmaster` VALUES ('BT', '2', 'デグレード', '');
INSERT INTO `tbl_generalmaster` VALUES ('CO', '1', '異常系', '');
INSERT INTO `tbl_generalmaster` VALUES ('CO', '2', '機能組合せ', '');
INSERT INTO `tbl_generalmaster` VALUES ('CO', '3', '限界値', '');
INSERT INTO `tbl_generalmaster` VALUES ('CO', '4', '特殊操作', '');
INSERT INTO `tbl_generalmaster` VALUES ('CO', '5', '正常系', '');
INSERT INTO `tbl_generalmaster` VALUES ('E1', '1', '大', ' ');
INSERT INTO `tbl_generalmaster` VALUES ('E1', '2', '中', ' ');
INSERT INTO `tbl_generalmaster` VALUES ('E1', '3', '小', ' ');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '1', 'ｼｽﾃﾑﾀﾞｳﾝ', '');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '2', 'ﾌｧｲﾙ/DB異常', '');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '3', '結果異常', '');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '4', '表示誤り', '');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '5', 'ﾌﾟﾛｸﾞﾗﾑ異常', '');
INSERT INTO `tbl_generalmaster` VALUES ('PH', '6', '規約に違反', '');
INSERT INTO `tbl_generalmaster` VALUES ('QD', '0', '質問区分', '');
INSERT INTO `tbl_generalmaster` VALUES ('QD', '1', '共通', '');
INSERT INTO `tbl_generalmaster` VALUES ('QD', '2', '環境', '');
INSERT INTO `tbl_generalmaster` VALUES ('QD', '3', '仕様', '');
INSERT INTO `tbl_generalmaster` VALUES ('QD', '4', '技術', '');
INSERT INTO `tbl_generalmaster` VALUES ('R1', '11', '需求分析', '');
INSERT INTO `tbl_generalmaster` VALUES ('R1', '12', '基本設計', '');
INSERT INTO `tbl_generalmaster` VALUES ('R1', '13', '詳細設計', '');
INSERT INTO `tbl_generalmaster` VALUES ('R1', '14', 'ｺｰﾃﾞｨﾝｸﾞ', '');
INSERT INTO `tbl_generalmaster` VALUES ('R2', '21', 'サーバ', '');
INSERT INTO `tbl_generalmaster` VALUES ('R2', '22', '端末', '');
INSERT INTO `tbl_generalmaster` VALUES ('R2', '23', '装置', '');
INSERT INTO `tbl_generalmaster` VALUES ('R3', '31', '操作ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('R3', '32', 'データ不正', '');
INSERT INTO `tbl_generalmaster` VALUES ('R4', '41', '説明書ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('R5', '51', '資料不足', '');
INSERT INTO `tbl_generalmaster` VALUES ('R5', '52', '不明', '');
INSERT INTO `tbl_generalmaster` VALUES ('R6', '61', '仕様変更', '');
INSERT INTO `tbl_generalmaster` VALUES ('R6', '62', '仕様理解ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '1', 'ｿﾌﾄﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '2', 'ﾊｰﾄﾞﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '3', '利用者ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '4', '説明書ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '5', '不明', '');
INSERT INTO `tbl_generalmaster` VALUES ('RD', '6', '仕様', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '00', '原因区分', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '01', '理解確認', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '02', '理解不足', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '03', '仕様ﾐｽ', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '04', '仕様不足', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '05', '仕様曖昧', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '06', '仕様変更', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '07', '業務改善', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '08', 'DB改善', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '09', '廃止/重複', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '10', '技術関連', '');
INSERT INTO `tbl_generalmaster` VALUES ('RQ', '11', 'その他', '');
INSERT INTO `tbl_generalmaster` VALUES ('TD', '1', 'ﾌﾟﾛｸﾞﾗﾑ修正', '');
INSERT INTO `tbl_generalmaster` VALUES ('TD', '2', '説明書修正', '');
INSERT INTO `tbl_generalmaster` VALUES ('TD', '3', '調査継続', '');
INSERT INTO `tbl_generalmaster` VALUES ('TD', '4', '仕様書修正', '');
INSERT INTO `tbl_generalmaster` VALUES ('TD', '5', '修正必要なし', '');
INSERT INTO `tbl_generalmaster` VALUES ('UP', '0', '普通ユーザー', '');
INSERT INTO `tbl_generalmaster` VALUES ('UP', '1', '管理員', '');
INSERT INTO `tbl_generalmaster` VALUES ('YS', '1', '普通', '');
INSERT INTO `tbl_generalmaster` VALUES ('YS', '2', '優先', '');
INSERT INTO `tbl_generalmaster` VALUES ('YS', '3', '緊急', '');

-- ----------------------------
-- Table structure for tbl_groupmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_groupmaster`;
CREATE TABLE `tbl_groupmaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `GROUPID` varchar(40) NOT NULL COMMENT 'グループＩＤ',
  `GROUPNAME` varchar(100) NOT NULL COMMENT 'グループ名称',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`PROJECTID`,`GROUPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='グループマスター';

-- ----------------------------
-- Records of tbl_groupmaster
-- ----------------------------
INSERT INTO `tbl_groupmaster` VALUES ('14028FSI01', '1', '機械査定', '0', '1', '2016-01-18 16:56:21.000');
INSERT INTO `tbl_groupmaster` VALUES ('14028FSI01', '4', '共通', '0', '1', '2016-03-21 10:06:37.000');

-- ----------------------------
-- Table structure for tbl_idmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_idmaster`;
CREATE TABLE `tbl_idmaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `COMPANYFLG` char(1) NOT NULL COMMENT '社内フラグ',
  `STAGE` char(1) NOT NULL COMMENT '摘出作業',
  `COMPANYNAME` varchar(5) NOT NULL COMMENT '会社名',
  `STAGENAME` varchar(3) NOT NULL COMMENT '作業名',
  `SERIALNO` char(5) NOT NULL COMMENT '連番',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='采番マスター';

-- ----------------------------
-- Records of tbl_idmaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_modulemaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_modulemaster`;
CREATE TABLE `tbl_modulemaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `GROUPID` varchar(40) NOT NULL COMMENT 'グループＩＤ',
  `MODULEID` varchar(40) NOT NULL COMMENT 'モジュールＩＤ',
  `MODULENAME` varchar(100) NOT NULL COMMENT 'モジュール名称',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`PROJECTID`,`GROUPID`,`MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='モジュールマスター';

-- ----------------------------
-- Records of tbl_modulemaster
-- ----------------------------
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '2', '案件フォルダ作成処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '20', 'MIB登録情報送信処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '22', 'オーソリ承認処理', '0', '1', '2016-03-01 10:06:18.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '24', '新契約申込TR作成処理', '0', '1', '2016-03-01 10:06:18.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '27', '業務会計処理', '0', '1', '2016-03-01 10:06:18.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '28', '新契約時変更 (承諾) 処理', '0', '1', '2016-03-01 10:06:18.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '29', '成立工程データ作成処理', '0', '1', '2016-03-01 10:06:18.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '3', '後送書類紐付け処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '4', '流用書類紐付け処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '5', '法人案件作成処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '6', '法人機械査定処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '7', 'ホスト送信前処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '8', '機械査定ホスト送信処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', '9', '機械査定ホスト受信処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP01', '機械査定サーバー処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP02', '査定案件投入処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP03', 'LINC結果受信処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP04', '成立後書類受付処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP05', '再査定経緯作成処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP06', '口座情報登録処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP07', '取報流用処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP09', '成立保留自動解除処理', '0', '1', '2016-03-01 10:06:17.000');
INSERT INTO `tbl_modulemaster` VALUES ('14028FSI01', '1', 'GNBCP10', '不成立データ登録処理', '0', '1', '2016-03-01 10:06:17.000');

-- ----------------------------
-- Table structure for tbl_projectmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_projectmaster`;
CREATE TABLE `tbl_projectmaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `PROJECTNAME` varchar(100) NOT NULL COMMENT 'プロジェクト名称',
  `COMPANYINCODE` varchar(6) NOT NULL COMMENT '社内得意先',
  `COMPANOUTCODE` varchar(6) NOT NULL COMMENT '社外得意先',
  `STARTDATE` datetime NOT NULL COMMENT '開始日付',
  `ENDDATE` datetime NOT NULL COMMENT '終了日付',
  `CHKENDDATE` datetime NOT NULL COMMENT '対応終了日付',
  `STATEFLG` char(1) NOT NULL COMMENT '状態フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `CHARGEID` varchar(16) NOT NULL COMMENT '責任者',
  PRIMARY KEY (`PROJECTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='プロジェクトマスター';

-- ----------------------------
-- Records of tbl_projectmaster
-- ----------------------------
INSERT INTO `tbl_projectmaster` VALUES ('14028FSI01', 'MBP项目管理系统', 'MBP', '1', '2016-01-18 16:57:31', '2016-01-19 16:57:33', '2016-01-18 16:57:36', '1', '1', '2016-05-09 16:27:49.577', '0', 'admin');

-- ----------------------------
-- Table structure for tbl_projectmembermaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_projectmembermaster`;
CREATE TABLE `tbl_projectmembermaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `USERID` varchar(16) NOT NULL COMMENT 'ユーサーＩＤ',
  `WORKTYPE` char(1) NOT NULL COMMENT '担当ＩＤ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`PROJECTID`,`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='メンバーマスター';

-- ----------------------------
-- Records of tbl_projectmembermaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_qa
-- ----------------------------
DROP TABLE IF EXISTS `tbl_qa`;
CREATE TABLE `tbl_qa` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `QANO` varchar(11) NOT NULL COMMENT 'Q&A番号',
  `GROUPID` varchar(40) DEFAULT NULL COMMENT 'グループＩＤ',
  `MODULEID` varchar(40) DEFAULT NULL COMMENT 'モジュールＩＤ',
  `COMPANYFLG` char(1) NOT NULL COMMENT '社内フラグ',
  `QAQSTATE` char(1) DEFAULT NULL COMMENT 'Q&A提出方状態',
  `QAASTATE` char(1) DEFAULT NULL COMMENT 'Q&A回答方状態',
  `STAGE` char(1) DEFAULT NULL COMMENT '摘出作業',
  `QUESTIONER` varchar(16) DEFAULT NULL COMMENT '提出者',
  `QUESTIONDATE` datetime DEFAULT NULL COMMENT '提出日',
  `EXPDATE` datetime DEFAULT NULL COMMENT '希望日',
  `ANSWERER` varchar(16) DEFAULT NULL COMMENT '回答者',
  `ANSWERDATE` datetime DEFAULT NULL COMMENT '回答日',
  `QATitle` text COMMENT 'QAタイトル',
  `QATitle_CN` text COMMENT 'QAタイトル（履歴）',
  `QUESTIONINFO` text COMMENT '質問内容',
  `QUESTIONINFO_CN` text COMMENT '質問内容（履歴）',
  `QATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '質問添付資料',
  `ANSWERINFO` text COMMENT '回答情報',
  `ANSWERINFO_CN` text COMMENT '回答情報（履歴）',
  `AATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '回答添付資料',
  `CAUSEDIV` char(2) DEFAULT NULL COMMENT '原因区分',
  `QUESTIONDIV` char(1) DEFAULT NULL COMMENT '質問区分',
  `RELATIONQANO` varchar(11) DEFAULT NULL COMMENT '関係Q&A',
  `REMARK` text COMMENT '備考',
  `REMARK_CN` text COMMENT '備考（履歴）',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`PROJECTID`,`QANO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Q&A情報';

-- ----------------------------
-- Records of tbl_qa
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_qahistory
-- ----------------------------
DROP TABLE IF EXISTS `tbl_qahistory`;
CREATE TABLE `tbl_qahistory` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `QANO` varchar(11) NOT NULL COMMENT 'Q&A番号',
  `SERIALNUM` varchar(5) NOT NULL COMMENT '連番',
  `GROUPID` varchar(40) DEFAULT NULL COMMENT 'グループＩＤ',
  `MODULEID` varchar(40) DEFAULT NULL COMMENT 'モジュールＩＤ',
  `COMPANYFLG` char(1) NOT NULL COMMENT '社内フラグ',
  `QAQSTATE` char(1) DEFAULT NULL COMMENT 'Q&A提出方状態',
  `QAASTATE` char(1) DEFAULT NULL COMMENT 'Q&A回答方状態',
  `STAGE` char(1) DEFAULT NULL COMMENT '摘出作業',
  `QUESTIONER` varchar(16) DEFAULT NULL COMMENT '提出者',
  `QUESTIONDATE` datetime DEFAULT NULL COMMENT '提出日',
  `EXPDATE` datetime DEFAULT NULL COMMENT '希望日',
  `ANSWERER` varchar(16) DEFAULT NULL COMMENT '回答者',
  `ANSWERDATE` datetime DEFAULT NULL COMMENT '回答日',
  `QATitle` text COMMENT 'QAタイトル',
  `QATitle_CN` text COMMENT 'QAタイトル（履歴）',
  `QUESTIONINFO` text COMMENT '質問内容',
  `QUESTIONINFO_CN` text COMMENT '質問内容（履歴）',
  `QATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '質問添付資料',
  `ANSWERINFO` text COMMENT '回答情報',
  `ANSWERINFO_CN` text COMMENT '回答情報（履歴）',
  `AATTACHEDINFO` varchar(255) DEFAULT NULL COMMENT '回答添付資料',
  `CAUSEDIV` char(2) DEFAULT NULL COMMENT '原因区分',
  `QUESTIONDIV` char(1) DEFAULT NULL COMMENT '質問区分',
  `RELATIONQANO` varchar(11) DEFAULT NULL COMMENT '関係Q&A',
  `REMARK` text COMMENT '備考',
  `REMARK_CN` text COMMENT '備考（履歴）',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`PROJECTID`,`QANO`,`SERIALNUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Q&A情報履歴';

-- ----------------------------
-- Records of tbl_qahistory
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_qaidmaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_qaidmaster`;
CREATE TABLE `tbl_qaidmaster` (
  `PROJECTID` varchar(40) NOT NULL COMMENT 'プロジェクトＩＤ',
  `COMPANYNAME` varchar(5) NOT NULL COMMENT '会社名',
  `SERIALNO` char(5) NOT NULL COMMENT '連番',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  KEY `projectId` (`PROJECTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='QA采番マスター';

-- ----------------------------
-- Records of tbl_qaidmaster
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_usermaster
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usermaster`;
CREATE TABLE `tbl_usermaster` (
  `USERID` varchar(16) NOT NULL COMMENT 'ユーサーＩＤ',
  `USERNAME` varchar(20) NOT NULL COMMENT 'ユーザー名称',
  `PASSWORD` varchar(40) NOT NULL COMMENT 'パスワード',
  `USERPREVL` char(1) NOT NULL COMMENT 'ユーザー権限',
  `COMPANYFLG` char(1) NOT NULL COMMENT '社内フラグ',
  `MAILADDRESS` varchar(40) NOT NULL COMMENT 'メール',
  `CUSTOMERCODE` varchar(6) NOT NULL COMMENT '得意先コード',
  `DEPARTMENTID` varchar(4) NOT NULL COMMENT '部門ＩＤ',
  `CLASSID` varchar(4) DEFAULT NULL COMMENT '課ＩＤ',
  `DELETEFLG` char(1) NOT NULL COMMENT '削除フラグ',
  `UPDATERID` varchar(16) NOT NULL COMMENT '更新ユーサーＩＤ',
  `UPDATETIME` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新日時',
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ユーサーマスター';

-- ----------------------------
-- Records of tbl_usermaster
-- ----------------------------
INSERT INTO `tbl_usermaster` VALUES ('admin', 'admin', 'D033E22AE348AEB5660FC2140AEC35850C4DA997', '1', '0', 'test@test.com', '2', '1', '2', '0', '1', '2016-05-10 15:20:08.000');
