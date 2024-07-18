
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE database IF NOT EXISTS neu1437;

use neu1437;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '系统管理员编号',
  `admin_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录编码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录密码',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', '测试管理员');
INSERT INTO `admin` VALUES (2, '123456', '123456', '测试管理员');

-- ----------------------------
-- Table structure for branch_table
-- ----------------------------
DROP TABLE IF EXISTS `branch_table`;
CREATE TABLE `branch_table`  (
  `branch_id` bigint NOT NULL,
  `xid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `transaction_id` bigint NULL DEFAULT NULL,
  `resource_group_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resource_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `branch_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT NULL,
  `client_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `application_data` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_create` datetime(6) NULL DEFAULT NULL,
  `gmt_modified` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`branch_id`) USING BTREE,
  INDEX `idx_xid`(`xid` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of branch_table
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_code` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市编号',
  `city_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市名',
  `province_id` int NOT NULL COMMENT '城市所属省份id',
  PRIMARY KEY (`city_code`) USING BTREE,
  INDEX `province_id`(`province_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('110101', '东城区', 110000);
INSERT INTO `city` VALUES ('110102', '西城区', 110000);
INSERT INTO `city` VALUES ('110105', '朝阳区', 110000);
INSERT INTO `city` VALUES ('110106', '丰台区', 110000);
INSERT INTO `city` VALUES ('110107', '石景山区', 110000);
INSERT INTO `city` VALUES ('110108', '海淀区', 110000);
INSERT INTO `city` VALUES ('110109', '门头沟区', 110000);
INSERT INTO `city` VALUES ('110111', '房山区', 110000);
INSERT INTO `city` VALUES ('110112', '通州区', 110000);
INSERT INTO `city` VALUES ('110113', '顺义区', 110000);
INSERT INTO `city` VALUES ('110114', '昌平区', 110000);
INSERT INTO `city` VALUES ('110115', '大兴区', 110000);
INSERT INTO `city` VALUES ('110116', '怀柔区', 110000);
INSERT INTO `city` VALUES ('110117', '平谷区', 110000);
INSERT INTO `city` VALUES ('110118', '密云区', 110000);
INSERT INTO `city` VALUES ('110119', '延庆区', 110000);
INSERT INTO `city` VALUES ('120101', '和平区', 120000);
INSERT INTO `city` VALUES ('120102', '河东区', 120000);
INSERT INTO `city` VALUES ('120103', '河西区', 120000);
INSERT INTO `city` VALUES ('120104', '南开区', 120000);
INSERT INTO `city` VALUES ('120105', '河北区', 120000);
INSERT INTO `city` VALUES ('120106', '红桥区', 120000);
INSERT INTO `city` VALUES ('120110', '东丽区', 120000);
INSERT INTO `city` VALUES ('120111', '西青区', 120000);
INSERT INTO `city` VALUES ('120112', '津南区', 120000);
INSERT INTO `city` VALUES ('120113', '北辰区', 120000);
INSERT INTO `city` VALUES ('120114', '武清区', 120000);
INSERT INTO `city` VALUES ('120115', '宝坻区', 120000);
INSERT INTO `city` VALUES ('120116', '滨海新区', 120000);
INSERT INTO `city` VALUES ('120117', '宁河区', 120000);
INSERT INTO `city` VALUES ('120118', '静海区', 120000);
INSERT INTO `city` VALUES ('120119', '蓟州区', 120000);
INSERT INTO `city` VALUES ('130100', '石家庄市', 130000);
INSERT INTO `city` VALUES ('130200', '唐山市', 130000);
INSERT INTO `city` VALUES ('130300', '秦皇岛市', 130000);
INSERT INTO `city` VALUES ('130400', '邯郸市', 130000);
INSERT INTO `city` VALUES ('130500', '邢台市', 130000);
INSERT INTO `city` VALUES ('130600', '保定市', 130000);
INSERT INTO `city` VALUES ('130700', '张家口市', 130000);
INSERT INTO `city` VALUES ('130800', '承德市', 130000);
INSERT INTO `city` VALUES ('130900', '沧州市', 130000);
INSERT INTO `city` VALUES ('131000', '廊坊市', 130000);
INSERT INTO `city` VALUES ('131100', '衡水市', 130000);
INSERT INTO `city` VALUES ('140100', '太原市', 140000);
INSERT INTO `city` VALUES ('140200', '大同市', 140000);
INSERT INTO `city` VALUES ('140300', '阳泉市', 140000);
INSERT INTO `city` VALUES ('140400', '长治市', 140000);
INSERT INTO `city` VALUES ('140500', '晋城市', 140000);
INSERT INTO `city` VALUES ('140600', '朔州市', 140000);
INSERT INTO `city` VALUES ('140700', '晋中市', 140000);
INSERT INTO `city` VALUES ('140800', '运城市', 140000);
INSERT INTO `city` VALUES ('140900', '忻州市', 140000);
INSERT INTO `city` VALUES ('141000', '临汾市', 140000);
INSERT INTO `city` VALUES ('141100', '吕梁市', 140000);
INSERT INTO `city` VALUES ('150100', '呼和浩特市', 150000);
INSERT INTO `city` VALUES ('150200', '包头市', 150000);
INSERT INTO `city` VALUES ('150300', '乌海市', 150000);
INSERT INTO `city` VALUES ('150400', '赤峰市', 150000);
INSERT INTO `city` VALUES ('150500', '通辽市', 150000);
INSERT INTO `city` VALUES ('150600', '鄂尔多斯市', 150000);
INSERT INTO `city` VALUES ('150700', '呼伦贝尔市', 150000);
INSERT INTO `city` VALUES ('150800', '巴彦淖尔市', 150000);
INSERT INTO `city` VALUES ('150900', '乌兰察布市', 150000);
INSERT INTO `city` VALUES ('152200', '兴安盟', 150000);
INSERT INTO `city` VALUES ('152500', '锡林郭勒盟', 150000);
INSERT INTO `city` VALUES ('152900', '阿拉善盟', 150000);
INSERT INTO `city` VALUES ('210100', '沈阳市', 210000);
INSERT INTO `city` VALUES ('210200', '大连市', 210000);
INSERT INTO `city` VALUES ('210300', '鞍山市', 210000);
INSERT INTO `city` VALUES ('210400', '抚顺市', 210000);
INSERT INTO `city` VALUES ('210500', '本溪市', 210000);
INSERT INTO `city` VALUES ('210600', '丹东市', 210000);
INSERT INTO `city` VALUES ('210700', '锦州市', 210000);
INSERT INTO `city` VALUES ('210800', '营口市', 210000);
INSERT INTO `city` VALUES ('210900', '阜新市', 210000);
INSERT INTO `city` VALUES ('211000', '辽阳市', 210000);
INSERT INTO `city` VALUES ('211100', '盘锦市', 210000);
INSERT INTO `city` VALUES ('211200', '铁岭市', 210000);
INSERT INTO `city` VALUES ('211300', '朝阳市', 210000);
INSERT INTO `city` VALUES ('211400', '葫芦岛市', 210000);
INSERT INTO `city` VALUES ('220100', '长春市', 220000);
INSERT INTO `city` VALUES ('220200', '吉林市', 220000);
INSERT INTO `city` VALUES ('220300', '四平市', 220000);
INSERT INTO `city` VALUES ('220400', '辽源市', 220000);
INSERT INTO `city` VALUES ('220500', '通化市', 220000);
INSERT INTO `city` VALUES ('220600', '白山市', 220000);
INSERT INTO `city` VALUES ('220700', '松原市', 220000);
INSERT INTO `city` VALUES ('220800', '白城市', 220000);
INSERT INTO `city` VALUES ('222400', '延边朝鲜族自治州', 220000);
INSERT INTO `city` VALUES ('230100', '哈尔滨市', 230000);
INSERT INTO `city` VALUES ('230200', '齐齐哈尔市', 230000);
INSERT INTO `city` VALUES ('230300', '鸡西市', 230000);
INSERT INTO `city` VALUES ('230400', '鹤岗市', 230000);
INSERT INTO `city` VALUES ('230500', '双鸭山市', 230000);
INSERT INTO `city` VALUES ('230600', '大庆市', 230000);
INSERT INTO `city` VALUES ('230700', '伊春市', 230000);
INSERT INTO `city` VALUES ('230800', '佳木斯市', 230000);
INSERT INTO `city` VALUES ('230900', '七台河市', 230000);
INSERT INTO `city` VALUES ('231000', '牡丹江市', 230000);
INSERT INTO `city` VALUES ('231100', '黑河市', 230000);
INSERT INTO `city` VALUES ('231200', '绥化市', 230000);
INSERT INTO `city` VALUES ('232700', '大兴安岭地区', 230000);
INSERT INTO `city` VALUES ('310101', '黄浦区', 310000);
INSERT INTO `city` VALUES ('310104', '徐汇区', 310000);
INSERT INTO `city` VALUES ('310105', '长宁区', 310000);
INSERT INTO `city` VALUES ('310106', '静安区', 310000);
INSERT INTO `city` VALUES ('310107', '普陀区', 310000);
INSERT INTO `city` VALUES ('310109', '虹口区', 310000);
INSERT INTO `city` VALUES ('310110', '杨浦区', 310000);
INSERT INTO `city` VALUES ('310112', '闵行区', 310000);
INSERT INTO `city` VALUES ('310113', '宝山区', 310000);
INSERT INTO `city` VALUES ('310114', '嘉定区', 310000);
INSERT INTO `city` VALUES ('310115', '浦东新区', 310000);
INSERT INTO `city` VALUES ('310116', '金山区', 310000);
INSERT INTO `city` VALUES ('310117', '松江区', 310000);
INSERT INTO `city` VALUES ('310118', '青浦区', 310000);
INSERT INTO `city` VALUES ('310120', '奉贤区', 310000);
INSERT INTO `city` VALUES ('310151', '崇明区', 310000);
INSERT INTO `city` VALUES ('320100', '南京市', 320000);
INSERT INTO `city` VALUES ('320200', '无锡市', 320000);
INSERT INTO `city` VALUES ('320300', '徐州市', 320000);
INSERT INTO `city` VALUES ('320400', '常州市', 320000);
INSERT INTO `city` VALUES ('320500', '苏州市', 320000);
INSERT INTO `city` VALUES ('320600', '南通市', 320000);
INSERT INTO `city` VALUES ('320700', '连云港市', 320000);
INSERT INTO `city` VALUES ('320800', '淮安市', 320000);
INSERT INTO `city` VALUES ('320900', '盐城市', 320000);
INSERT INTO `city` VALUES ('321000', '扬州市', 320000);
INSERT INTO `city` VALUES ('321100', '镇江市', 320000);
INSERT INTO `city` VALUES ('321200', '泰州市', 320000);
INSERT INTO `city` VALUES ('321300', '宿迁市', 320000);
INSERT INTO `city` VALUES ('330100', '杭州市', 330000);
INSERT INTO `city` VALUES ('330200', '宁波市', 330000);
INSERT INTO `city` VALUES ('330300', '温州市', 330000);
INSERT INTO `city` VALUES ('330400', '嘉兴市', 330000);
INSERT INTO `city` VALUES ('330500', '湖州市', 330000);
INSERT INTO `city` VALUES ('330600', '绍兴市', 330000);
INSERT INTO `city` VALUES ('330700', '金华市', 330000);
INSERT INTO `city` VALUES ('330800', '衢州市', 330000);
INSERT INTO `city` VALUES ('330900', '舟山市', 330000);
INSERT INTO `city` VALUES ('331000', '台州市', 330000);
INSERT INTO `city` VALUES ('331100', '丽水市', 330000);
INSERT INTO `city` VALUES ('340100', '合肥市', 340000);
INSERT INTO `city` VALUES ('340200', '芜湖市', 340000);
INSERT INTO `city` VALUES ('340300', '蚌埠市', 340000);
INSERT INTO `city` VALUES ('340400', '淮南市', 340000);
INSERT INTO `city` VALUES ('340500', '马鞍山市', 340000);
INSERT INTO `city` VALUES ('340600', '淮北市', 340000);
INSERT INTO `city` VALUES ('340700', '铜陵市', 340000);
INSERT INTO `city` VALUES ('340800', '安庆市', 340000);
INSERT INTO `city` VALUES ('341000', '黄山市', 340000);
INSERT INTO `city` VALUES ('341100', '滁州市', 340000);
INSERT INTO `city` VALUES ('341200', '阜阳市', 340000);
INSERT INTO `city` VALUES ('341300', '宿州市', 340000);
INSERT INTO `city` VALUES ('341500', '六安市', 340000);
INSERT INTO `city` VALUES ('341600', '亳州市', 340000);
INSERT INTO `city` VALUES ('341700', '池州市', 340000);
INSERT INTO `city` VALUES ('341800', '宣城市', 340000);
INSERT INTO `city` VALUES ('350100', '福州市', 350000);
INSERT INTO `city` VALUES ('350200', '厦门市', 350000);
INSERT INTO `city` VALUES ('350300', '莆田市', 350000);
INSERT INTO `city` VALUES ('350400', '三明市', 350000);
INSERT INTO `city` VALUES ('350500', '泉州市', 350000);
INSERT INTO `city` VALUES ('350600', '漳州市', 350000);
INSERT INTO `city` VALUES ('350700', '南平市', 350000);
INSERT INTO `city` VALUES ('350800', '龙岩市', 350000);
INSERT INTO `city` VALUES ('350900', '宁德市', 350000);
INSERT INTO `city` VALUES ('360100', '南昌市', 360000);
INSERT INTO `city` VALUES ('360200', '景德镇市', 360000);
INSERT INTO `city` VALUES ('360300', '萍乡市', 360000);
INSERT INTO `city` VALUES ('360400', '九江市', 360000);
INSERT INTO `city` VALUES ('360500', '新余市', 360000);
INSERT INTO `city` VALUES ('360600', '鹰潭市', 360000);
INSERT INTO `city` VALUES ('360700', '赣州市', 360000);
INSERT INTO `city` VALUES ('360800', '吉安市', 360000);
INSERT INTO `city` VALUES ('360900', '宜春市', 360000);
INSERT INTO `city` VALUES ('361000', '抚州市', 360000);
INSERT INTO `city` VALUES ('361100', '上饶市', 360000);
INSERT INTO `city` VALUES ('370100', '济南市', 370000);
INSERT INTO `city` VALUES ('370200', '青岛市', 370000);
INSERT INTO `city` VALUES ('370300', '淄博市', 370000);
INSERT INTO `city` VALUES ('370400', '枣庄市', 370000);
INSERT INTO `city` VALUES ('370500', '东营市', 370000);
INSERT INTO `city` VALUES ('370600', '烟台市', 370000);
INSERT INTO `city` VALUES ('370700', '潍坊市', 370000);
INSERT INTO `city` VALUES ('370800', '济宁市', 370000);
INSERT INTO `city` VALUES ('370900', '泰安市', 370000);
INSERT INTO `city` VALUES ('371000', '威海市', 370000);
INSERT INTO `city` VALUES ('371100', '日照市', 370000);
INSERT INTO `city` VALUES ('371300', '临沂市', 370000);
INSERT INTO `city` VALUES ('371400', '德州市', 370000);
INSERT INTO `city` VALUES ('371500', '聊城市', 370000);
INSERT INTO `city` VALUES ('371600', '滨州市', 370000);
INSERT INTO `city` VALUES ('371700', '菏泽市', 370000);
INSERT INTO `city` VALUES ('410100', '郑州市', 410000);
INSERT INTO `city` VALUES ('410200', '开封市', 410000);
INSERT INTO `city` VALUES ('410300', '洛阳市', 410000);
INSERT INTO `city` VALUES ('410400', '平顶山市', 410000);
INSERT INTO `city` VALUES ('410500', '安阳市', 410000);
INSERT INTO `city` VALUES ('410600', '鹤壁市', 410000);
INSERT INTO `city` VALUES ('410700', '新乡市', 410000);
INSERT INTO `city` VALUES ('410800', '焦作市', 410000);
INSERT INTO `city` VALUES ('410900', '濮阳市', 410000);
INSERT INTO `city` VALUES ('411000', '许昌市', 410000);
INSERT INTO `city` VALUES ('411100', '漯河市', 410000);
INSERT INTO `city` VALUES ('411200', '三门峡市', 410000);
INSERT INTO `city` VALUES ('411300', '南阳市', 410000);
INSERT INTO `city` VALUES ('411400', '商丘市', 410000);
INSERT INTO `city` VALUES ('411500', '信阳市', 410000);
INSERT INTO `city` VALUES ('411600', '周口市', 410000);
INSERT INTO `city` VALUES ('411700', '驻马店市', 410000);
INSERT INTO `city` VALUES ('419001', '济源市', 410000);
INSERT INTO `city` VALUES ('420100', '武汉市', 420000);
INSERT INTO `city` VALUES ('420200', '黄石市', 420000);
INSERT INTO `city` VALUES ('420300', '十堰市', 420000);
INSERT INTO `city` VALUES ('420500', '宜昌市', 420000);
INSERT INTO `city` VALUES ('420600', '襄阳市', 420000);
INSERT INTO `city` VALUES ('420700', '鄂州市', 420000);
INSERT INTO `city` VALUES ('420800', '荆门市', 420000);
INSERT INTO `city` VALUES ('420900', '孝感市', 420000);
INSERT INTO `city` VALUES ('421000', '荆州市', 420000);
INSERT INTO `city` VALUES ('421100', '黄冈市', 420000);
INSERT INTO `city` VALUES ('421200', '咸宁市', 420000);
INSERT INTO `city` VALUES ('421300', '随州市', 420000);
INSERT INTO `city` VALUES ('422800', '恩施土家族苗族自治州', 420000);
INSERT INTO `city` VALUES ('429004', '仙桃市', 420000);
INSERT INTO `city` VALUES ('429005', '潜江市', 420000);
INSERT INTO `city` VALUES ('429006', '天门市', 420000);
INSERT INTO `city` VALUES ('429021', '神农架林区', 420000);
INSERT INTO `city` VALUES ('430100', '长沙市', 430000);
INSERT INTO `city` VALUES ('430200', '株洲市', 430000);
INSERT INTO `city` VALUES ('430300', '湘潭市', 430000);
INSERT INTO `city` VALUES ('430400', '衡阳市', 430000);
INSERT INTO `city` VALUES ('430500', '邵阳市', 430000);
INSERT INTO `city` VALUES ('430600', '岳阳市', 430000);
INSERT INTO `city` VALUES ('430700', '常德市', 430000);
INSERT INTO `city` VALUES ('430800', '张家界市', 430000);
INSERT INTO `city` VALUES ('430900', '益阳市', 430000);
INSERT INTO `city` VALUES ('431000', '郴州市', 430000);
INSERT INTO `city` VALUES ('431100', '永州市', 430000);
INSERT INTO `city` VALUES ('431200', '怀化市', 430000);
INSERT INTO `city` VALUES ('431300', '娄底市', 430000);
INSERT INTO `city` VALUES ('433100', '湘西土家族苗族自治州', 430000);
INSERT INTO `city` VALUES ('440100', '广州市', 440000);
INSERT INTO `city` VALUES ('440200', '韶关市', 440000);
INSERT INTO `city` VALUES ('440300', '深圳市', 440000);
INSERT INTO `city` VALUES ('440400', '珠海市', 440000);
INSERT INTO `city` VALUES ('440500', '汕头市', 440000);
INSERT INTO `city` VALUES ('440600', '佛山市', 440000);
INSERT INTO `city` VALUES ('440700', '江门市', 440000);
INSERT INTO `city` VALUES ('440800', '湛江市', 440000);
INSERT INTO `city` VALUES ('440900', '茂名市', 440000);
INSERT INTO `city` VALUES ('441200', '肇庆市', 440000);
INSERT INTO `city` VALUES ('441300', '惠州市', 440000);
INSERT INTO `city` VALUES ('441400', '梅州市', 440000);
INSERT INTO `city` VALUES ('441500', '汕尾市', 440000);
INSERT INTO `city` VALUES ('441600', '河源市', 440000);
INSERT INTO `city` VALUES ('441700', '阳江市', 440000);
INSERT INTO `city` VALUES ('441800', '清远市', 440000);
INSERT INTO `city` VALUES ('441900', '东莞市', 440000);
INSERT INTO `city` VALUES ('442000', '中山市', 440000);
INSERT INTO `city` VALUES ('445100', '潮州市', 440000);
INSERT INTO `city` VALUES ('445200', '揭阳市', 440000);
INSERT INTO `city` VALUES ('445300', '云浮市', 440000);
INSERT INTO `city` VALUES ('450100', '南宁市', 450000);
INSERT INTO `city` VALUES ('450200', '柳州市', 450000);
INSERT INTO `city` VALUES ('450300', '桂林市', 450000);
INSERT INTO `city` VALUES ('450400', '梧州市', 450000);
INSERT INTO `city` VALUES ('450500', '北海市', 450000);
INSERT INTO `city` VALUES ('450600', '防城港市', 450000);
INSERT INTO `city` VALUES ('450700', '钦州市', 450000);
INSERT INTO `city` VALUES ('450800', '贵港市', 450000);
INSERT INTO `city` VALUES ('450900', '玉林市', 450000);
INSERT INTO `city` VALUES ('451000', '百色市', 450000);
INSERT INTO `city` VALUES ('451100', '贺州市', 450000);
INSERT INTO `city` VALUES ('451200', '河池市', 450000);
INSERT INTO `city` VALUES ('451300', '来宾市', 450000);
INSERT INTO `city` VALUES ('451400', '崇左市', 450000);
INSERT INTO `city` VALUES ('460100', '海口市', 460000);
INSERT INTO `city` VALUES ('460200', '三亚市', 460000);
INSERT INTO `city` VALUES ('460300', '三沙市', 460000);
INSERT INTO `city` VALUES ('460400', '儋州市', 460000);
INSERT INTO `city` VALUES ('469001', '五指山市', 460000);
INSERT INTO `city` VALUES ('469002', '琼海市', 460000);
INSERT INTO `city` VALUES ('469005', '文昌市', 460000);
INSERT INTO `city` VALUES ('469006', '万宁市', 460000);
INSERT INTO `city` VALUES ('469007', '东方市', 460000);
INSERT INTO `city` VALUES ('469021', '定安县', 460000);
INSERT INTO `city` VALUES ('469022', '屯昌县', 460000);
INSERT INTO `city` VALUES ('469023', '澄迈县', 460000);
INSERT INTO `city` VALUES ('469024', '临高县', 460000);
INSERT INTO `city` VALUES ('469025', '白沙黎族自治县', 460000);
INSERT INTO `city` VALUES ('469026', '昌江黎族自治县', 460000);
INSERT INTO `city` VALUES ('469027', '乐东黎族自治县', 460000);
INSERT INTO `city` VALUES ('469028', '陵水黎族自治县', 460000);
INSERT INTO `city` VALUES ('469029', '保亭黎族苗族自治县', 460000);
INSERT INTO `city` VALUES ('469030', '琼中黎族苗族自治县', 460000);
INSERT INTO `city` VALUES ('500101', '万州区', 500000);
INSERT INTO `city` VALUES ('500102', '涪陵区', 500000);
INSERT INTO `city` VALUES ('500103', '渝中区', 500000);
INSERT INTO `city` VALUES ('500104', '大渡口区', 500000);
INSERT INTO `city` VALUES ('500105', '江北区', 500000);
INSERT INTO `city` VALUES ('500106', '沙坪坝区', 500000);
INSERT INTO `city` VALUES ('500107', '九龙坡区', 500000);
INSERT INTO `city` VALUES ('500108', '南岸区', 500000);
INSERT INTO `city` VALUES ('500109', '北碚区', 500000);
INSERT INTO `city` VALUES ('500110', '綦江区', 500000);
INSERT INTO `city` VALUES ('500111', '大足区', 500000);
INSERT INTO `city` VALUES ('500112', '渝北区', 500000);
INSERT INTO `city` VALUES ('500113', '巴南区', 500000);
INSERT INTO `city` VALUES ('500114', '黔江区', 500000);
INSERT INTO `city` VALUES ('500115', '长寿区', 500000);
INSERT INTO `city` VALUES ('500116', '江津区', 500000);
INSERT INTO `city` VALUES ('500117', '合川区', 500000);
INSERT INTO `city` VALUES ('500118', '永川区', 500000);
INSERT INTO `city` VALUES ('500119', '南川区', 500000);
INSERT INTO `city` VALUES ('500120', '璧山区', 500000);
INSERT INTO `city` VALUES ('500151', '铜梁区', 500000);
INSERT INTO `city` VALUES ('500152', '潼南区', 500000);
INSERT INTO `city` VALUES ('500153', '荣昌区', 500000);
INSERT INTO `city` VALUES ('500154', '开州区', 500000);
INSERT INTO `city` VALUES ('500155', '梁平区', 500000);
INSERT INTO `city` VALUES ('500156', '武隆区', 500000);
INSERT INTO `city` VALUES ('500229', '城口县', 500000);
INSERT INTO `city` VALUES ('500230', '丰都县', 500000);
INSERT INTO `city` VALUES ('500231', '垫江县', 500000);
INSERT INTO `city` VALUES ('500233', '忠县', 500000);
INSERT INTO `city` VALUES ('500235', '云阳县', 500000);
INSERT INTO `city` VALUES ('500236', '奉节县', 500000);
INSERT INTO `city` VALUES ('500237', '巫山县', 500000);
INSERT INTO `city` VALUES ('500238', '巫溪县', 500000);
INSERT INTO `city` VALUES ('500240', '石柱土家族自治县', 500000);
INSERT INTO `city` VALUES ('500241', '秀山土家族苗族自治县', 500000);
INSERT INTO `city` VALUES ('500242', '酉阳土家族苗族自治县', 500000);
INSERT INTO `city` VALUES ('500243', '彭水苗族土家族自治县', 500000);
INSERT INTO `city` VALUES ('510100', '成都市', 510000);
INSERT INTO `city` VALUES ('510300', '自贡市', 510000);
INSERT INTO `city` VALUES ('510400', '攀枝花市', 510000);
INSERT INTO `city` VALUES ('510500', '泸州市', 510000);
INSERT INTO `city` VALUES ('510600', '德阳市', 510000);
INSERT INTO `city` VALUES ('510700', '绵阳市', 510000);
INSERT INTO `city` VALUES ('510800', '广元市', 510000);
INSERT INTO `city` VALUES ('510900', '遂宁市', 510000);
INSERT INTO `city` VALUES ('511000', '内江市', 510000);
INSERT INTO `city` VALUES ('511100', '乐山市', 510000);
INSERT INTO `city` VALUES ('511300', '南充市', 510000);
INSERT INTO `city` VALUES ('511400', '眉山市', 510000);
INSERT INTO `city` VALUES ('511500', '宜宾市', 510000);
INSERT INTO `city` VALUES ('511600', '广安市', 510000);
INSERT INTO `city` VALUES ('511700', '达州市', 510000);
INSERT INTO `city` VALUES ('511800', '雅安市', 510000);
INSERT INTO `city` VALUES ('511900', '巴中市', 510000);
INSERT INTO `city` VALUES ('512000', '资阳市', 510000);
INSERT INTO `city` VALUES ('513200', '阿坝藏族羌族自治州', 510000);
INSERT INTO `city` VALUES ('513300', '甘孜藏族自治州', 510000);
INSERT INTO `city` VALUES ('513400', '凉山彝族自治州', 510000);
INSERT INTO `city` VALUES ('520100', '贵阳市', 520000);
INSERT INTO `city` VALUES ('520200', '六盘水市', 520000);
INSERT INTO `city` VALUES ('520300', '遵义市', 520000);
INSERT INTO `city` VALUES ('520400', '安顺市', 520000);
INSERT INTO `city` VALUES ('520500', '毕节市', 520000);
INSERT INTO `city` VALUES ('520600', '铜仁市', 520000);
INSERT INTO `city` VALUES ('522300', '黔西南布依族苗族自治州', 520000);
INSERT INTO `city` VALUES ('522600', '黔东南苗族侗族自治州', 520000);
INSERT INTO `city` VALUES ('522700', '黔南布依族苗族自治州', 520000);
INSERT INTO `city` VALUES ('530100', '昆明市', 530000);
INSERT INTO `city` VALUES ('530300', '曲靖市', 530000);
INSERT INTO `city` VALUES ('530400', '玉溪市', 530000);
INSERT INTO `city` VALUES ('530500', '保山市', 530000);
INSERT INTO `city` VALUES ('530600', '昭通市', 530000);
INSERT INTO `city` VALUES ('530700', '丽江市', 530000);
INSERT INTO `city` VALUES ('530800', '普洱市', 530000);
INSERT INTO `city` VALUES ('530900', '临沧市', 530000);
INSERT INTO `city` VALUES ('532300', '楚雄彝族自治州', 530000);
INSERT INTO `city` VALUES ('532500', '红河哈尼族彝族自治州', 530000);
INSERT INTO `city` VALUES ('532600', '文山壮族苗族自治州', 530000);
INSERT INTO `city` VALUES ('532800', '西双版纳傣族自治州', 530000);
INSERT INTO `city` VALUES ('532900', '大理白族自治州', 530000);
INSERT INTO `city` VALUES ('533100', '德宏傣族景颇族自治州', 530000);
INSERT INTO `city` VALUES ('533300', '怒江傈僳族自治州', 530000);
INSERT INTO `city` VALUES ('533400', '迪庆藏族自治州', 530000);
INSERT INTO `city` VALUES ('540100', '拉萨市', 540000);
INSERT INTO `city` VALUES ('540200', '日喀则市', 540000);
INSERT INTO `city` VALUES ('540300', '昌都市', 540000);
INSERT INTO `city` VALUES ('540400', '林芝市', 540000);
INSERT INTO `city` VALUES ('540500', '山南市', 540000);
INSERT INTO `city` VALUES ('540600', '那曲市', 540000);
INSERT INTO `city` VALUES ('542500', '阿里地区', 540000);
INSERT INTO `city` VALUES ('610100', '西安市', 610000);
INSERT INTO `city` VALUES ('610200', '铜川市', 610000);
INSERT INTO `city` VALUES ('610300', '宝鸡市', 610000);
INSERT INTO `city` VALUES ('610400', '咸阳市', 610000);
INSERT INTO `city` VALUES ('610500', '渭南市', 610000);
INSERT INTO `city` VALUES ('610600', '延安市', 610000);
INSERT INTO `city` VALUES ('610700', '汉中市', 610000);
INSERT INTO `city` VALUES ('610800', '榆林市', 610000);
INSERT INTO `city` VALUES ('610900', '安康市', 610000);
INSERT INTO `city` VALUES ('611000', '商洛市', 610000);
INSERT INTO `city` VALUES ('620100', '兰州市', 620000);
INSERT INTO `city` VALUES ('620200', '嘉峪关市', 620000);
INSERT INTO `city` VALUES ('620300', '金昌市', 620000);
INSERT INTO `city` VALUES ('620400', '白银市', 620000);
INSERT INTO `city` VALUES ('620500', '天水市', 620000);
INSERT INTO `city` VALUES ('620600', '武威市', 620000);
INSERT INTO `city` VALUES ('620700', '张掖市', 620000);
INSERT INTO `city` VALUES ('620800', '平凉市', 620000);
INSERT INTO `city` VALUES ('620900', '酒泉市', 620000);
INSERT INTO `city` VALUES ('621000', '庆阳市', 620000);
INSERT INTO `city` VALUES ('621100', '定西市', 620000);
INSERT INTO `city` VALUES ('621200', '陇南市', 620000);
INSERT INTO `city` VALUES ('622900', '临夏回族自治州', 620000);
INSERT INTO `city` VALUES ('623000', '甘南藏族自治州', 620000);
INSERT INTO `city` VALUES ('630100', '西宁市', 630000);
INSERT INTO `city` VALUES ('630200', '海东市', 630000);
INSERT INTO `city` VALUES ('632200', '海北藏族自治州', 630000);
INSERT INTO `city` VALUES ('632300', '黄南藏族自治州', 630000);
INSERT INTO `city` VALUES ('632500', '海南藏族自治州', 630000);
INSERT INTO `city` VALUES ('632600', '果洛藏族自治州', 630000);
INSERT INTO `city` VALUES ('632700', '玉树藏族自治州', 630000);
INSERT INTO `city` VALUES ('632800', '海西蒙古族藏族自治州', 630000);
INSERT INTO `city` VALUES ('640100', '银川市', 640000);
INSERT INTO `city` VALUES ('640200', '石嘴山市', 640000);
INSERT INTO `city` VALUES ('640300', '吴忠市', 640000);
INSERT INTO `city` VALUES ('640400', '固原市', 640000);
INSERT INTO `city` VALUES ('640500', '中卫市', 640000);
INSERT INTO `city` VALUES ('650100', '乌鲁木齐市', 650000);
INSERT INTO `city` VALUES ('650200', '克拉玛依市', 650000);
INSERT INTO `city` VALUES ('650400', '吐鲁番市', 650000);
INSERT INTO `city` VALUES ('650500', '哈密市', 650000);
INSERT INTO `city` VALUES ('652300', '昌吉回族自治州', 650000);
INSERT INTO `city` VALUES ('652700', '博尔塔拉蒙古自治州', 650000);
INSERT INTO `city` VALUES ('652800', '巴音郭楞蒙古自治州', 650000);
INSERT INTO `city` VALUES ('652900', '阿克苏地区', 650000);
INSERT INTO `city` VALUES ('653000', '克孜勒苏柯尔克孜自治州', 650000);
INSERT INTO `city` VALUES ('653100', '喀什地区', 650000);
INSERT INTO `city` VALUES ('653200', '和田地区', 650000);
INSERT INTO `city` VALUES ('654000', '伊犁哈萨克自治州', 650000);
INSERT INTO `city` VALUES ('654200', '塔城地区', 650000);
INSERT INTO `city` VALUES ('654300', '阿勒泰地区', 650000);
INSERT INTO `city` VALUES ('659001', '石河子市', 650000);
INSERT INTO `city` VALUES ('659002', '阿拉尔市', 650000);
INSERT INTO `city` VALUES ('659003', '图木舒克市', 650000);
INSERT INTO `city` VALUES ('659004', '五家渠市', 650000);
INSERT INTO `city` VALUES ('659005', '北屯市', 650000);
INSERT INTO `city` VALUES ('659006', '铁门关市', 650000);
INSERT INTO `city` VALUES ('659007', '双河市', 650000);
INSERT INTO `city` VALUES ('659008', '可克达拉市', 650000);
INSERT INTO `city` VALUES ('659009', '昆玉市', 650000);
INSERT INTO `city` VALUES ('659010', '胡杨河市', 650000);
INSERT INTO `city` VALUES ('710001', '台湾', 710000);
INSERT INTO `city` VALUES ('810001', '中西区', 810000);
INSERT INTO `city` VALUES ('810002', '湾仔区', 810000);
INSERT INTO `city` VALUES ('810003', '东区', 810000);
INSERT INTO `city` VALUES ('810004', '南区', 810000);
INSERT INTO `city` VALUES ('810005', '油尖旺区', 810000);
INSERT INTO `city` VALUES ('810006', '深水埗区', 810000);
INSERT INTO `city` VALUES ('810007', '九龙城区', 810000);
INSERT INTO `city` VALUES ('810008', '黄大仙区', 810000);
INSERT INTO `city` VALUES ('810009', '观塘区', 810000);
INSERT INTO `city` VALUES ('810010', '荃湾区', 810000);
INSERT INTO `city` VALUES ('810011', '屯门区', 810000);
INSERT INTO `city` VALUES ('810012', '元朗区', 810000);
INSERT INTO `city` VALUES ('810013', '北区', 810000);
INSERT INTO `city` VALUES ('810014', '大埔区', 810000);
INSERT INTO `city` VALUES ('810015', '西贡区', 810000);
INSERT INTO `city` VALUES ('810016', '沙田区', 810000);
INSERT INTO `city` VALUES ('810017', '葵青区', 810000);
INSERT INTO `city` VALUES ('810018', '离岛区', 810000);
INSERT INTO `city` VALUES ('820001', '花地玛堂区', 820000);
INSERT INTO `city` VALUES ('820002', '花王堂区', 820000);
INSERT INTO `city` VALUES ('820003', '望德堂区', 820000);
INSERT INTO `city` VALUES ('820004', '大堂区', 820000);
INSERT INTO `city` VALUES ('820005', '风顺堂区', 820000);
INSERT INTO `city` VALUES ('820006', '嘉模堂区', 820000);
INSERT INTO `city` VALUES ('820007', '路凼填海区', 820000);
INSERT INTO `city` VALUES ('820008', '圣方济各堂区', 820000);

-- ----------------------------
-- Table structure for distributed_lock
-- ----------------------------
DROP TABLE IF EXISTS `distributed_lock`;
CREATE TABLE `distributed_lock`  (
  `lock_key` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lock_value` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `expire` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`lock_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of distributed_lock
-- ----------------------------
INSERT INTO `distributed_lock` VALUES ('AsyncCommitting', ' ', 0);
INSERT INTO `distributed_lock` VALUES ('RetryCommitting', '192.168.137.1:8091', 1721024551180);
INSERT INTO `distributed_lock` VALUES ('RetryRollbacking', '192.168.137.1:8091', 1721024551282);
INSERT INTO `distributed_lock` VALUES ('TxTimeoutCheck', '192.168.137.1:8091', 1721024550975);
INSERT INTO `distributed_lock` VALUES ('UndologDelete', ' ', 0);

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table`  (
  `xid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `transaction_id` bigint NULL DEFAULT NULL,
  `status` tinyint NOT NULL,
  `application_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `transaction_service_group` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `transaction_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `timeout` int NULL DEFAULT NULL,
  `begin_time` bigint NULL DEFAULT NULL,
  `application_data` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_create` datetime NULL DEFAULT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`xid`) USING BTREE,
  INDEX `idx_status_gmt_modified`(`status` ASC, `gmt_modified` ASC) USING BTREE,
  INDEX `idx_transaction_id`(`transaction_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_table
-- ----------------------------

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `info_id` int NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `status` int NOT NULL DEFAULT 1 COMMENT '0已删除\r\n1公众监督员supervisor已提交\r\n2已指派网格员inspector\r\n3网格员inspector已填写',
  `aqi_level` int NOT NULL COMMENT 'aqi等级1-6',
  `city_code` int NOT NULL COMMENT '城市代码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `feedback` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息',
  `time_supervisor` datetime NOT NULL COMMENT '反馈时间（公众监督员）',
  `time_inspector` datetime NULL DEFAULT NULL COMMENT '反馈时间（网格员）',
  `so2` double NULL DEFAULT NULL COMMENT 'so2浓度',
  `co` double NULL DEFAULT NULL COMMENT 'co浓度',
  `o3` double NULL DEFAULT NULL COMMENT '臭氧',
  `pm25` double NULL DEFAULT NULL COMMENT 'pm2.5浓度',
  `supervisor_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员姓名',
  `inspector_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网格员姓名',
  `aqi_real` int NULL DEFAULT NULL COMMENT 'aqi的值',
  PRIMARY KEY (`info_id`) USING BTREE,
  INDEX `city_code`(`city_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 409 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, 0, 3, 110108, '塔院盛夏园3栋（大学路）', '呼吸伴有强烈的颗粒感', '2024-04-11 09:15:23', NULL, NULL, NULL, NULL, NULL, '李狗蛋', NULL, NULL);
INSERT INTO `info` VALUES (2, 0, 1, 150500, '公寓街尚事小区旁花园', '整体空气质量优良，呼吸舒适', '2024-05-03 10:41:19', NULL, NULL, NULL, NULL, NULL, '袁江霞', NULL, NULL);
INSERT INTO `info` VALUES (3, 1, 1, 431000, '黄浦区淮海中路951号', '测试数据的反馈信息', '2024-05-02 15:49:08', NULL, NULL, NULL, NULL, NULL, '李狗蛋', NULL, NULL);
INSERT INTO `info` VALUES (4, 2, 3, 441900, '浦东新区健祥路392号', '测试数据的反馈信息', '2024-05-13 01:11:22', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '张三网', NULL);
INSERT INTO `info` VALUES (5, 2, 4, 620600, '罗湖区蔡屋围深南东路950号', '测试数据的反馈信息', '2024-05-21 15:32:14', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '张三网', NULL);
INSERT INTO `info` VALUES (6, 2, 5, 130200, '房山区岳琉路234号', '测试数据的反馈信息', '2024-06-14 07:01:13', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '张三网', NULL);
INSERT INTO `info` VALUES (7, 2, 2, 652800, '罗湖区清水河一路144号', '测试数据的反馈信息', '2024-06-21 04:41:37', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '张三网', NULL);
INSERT INTO `info` VALUES (8, 2, 1, 220600, '延庆区028县道954号', '测试数据的反馈信息', '2024-05-06 05:47:13', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (9, 2, 3, 210800, '紫马岭商圈中山五路22号', '测试数据的反馈信息', '2024-06-17 12:28:12', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (10, 2, 4, 652700, '京华商圈华夏街770号', '测试数据的反馈信息', '2024-05-21 07:57:22', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (11, 2, 2, 120116, '西城区西長安街919号', '测试数据的反馈信息', '2024-05-29 19:12:34', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (12, 2, 3, 110108, '徐汇区虹桥路749号', '测试数据的反馈信息', '2024-06-14 20:35:31', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (13, 2, 1, 310107, '房山区岳琉路819号', '测试数据的反馈信息', '2024-05-31 14:07:23', NULL, NULL, NULL, NULL, NULL, '李狗蛋', '李四格', NULL);
INSERT INTO `info` VALUES (14, 3, 3, 469007, '福田区深南大道917号', '测试数据的反馈信息', '2024-05-03 04:57:05', '2024-07-02 14:14:27', 79.26, 1.1, 130.25, 36.2, '李狗蛋', '张三网', 80);
INSERT INTO `info` VALUES (15, 3, 2, 500108, '天河区大信商圈大信南路725号', '测试数据的反馈信息', '2024-05-10 06:46:56', '2024-07-03 14:14:33', 131.9, 11.2, 216.23, 69.1, '李狗蛋', '张三网', 175);
INSERT INTO `info` VALUES (16, 3, 4, 810016, '锦江区红星路三段669号', '测试数据的反馈信息', '2024-05-06 19:48:46', '2024-07-04 14:14:37', 302.05, 16.72, 405.2, 189.2, '李狗蛋', '张三网', 306);
INSERT INTO `info` VALUES (17, 3, 1, 810006, '西城区复兴门内大街689号', '测试数据的反馈信息', '2024-06-28 23:06:35', '2024-07-05 14:14:40', 17.9, 2.1, 40.71, 21.4, '李狗蛋', '张三网', 19);
INSERT INTO `info` VALUES (18, 3, 1, 130900, '越秀区中山二路33号', '测试数据的反馈信息', '2024-05-06 16:18:00', '2024-07-08 14:14:43', 13.2, 0.75, 39.2, 9.21, '李狗蛋', '张三网', 16);
INSERT INTO `info` VALUES (19, 3, 5, 371100, '越秀区中山二路534号', '测试数据的反馈信息', '2024-05-31 19:57:48', '2024-07-09 14:14:47', 406.72, 21.42, 697.31, 301.25, '李狗蛋', '张三网', 571);
INSERT INTO `info` VALUES (20, 3, 3, 411700, '锦江区红星路三段13号', '测试数据的反馈信息', '2024-05-02 23:15:32', '2024-07-04 14:14:50', 79.26, 1.1, 130.25, 36.2, '李狗蛋', '李四格', 80);
INSERT INTO `info` VALUES (21, 3, 2, 445300, '白云区小坪东路116号', '测试数据的反馈信息', '2024-05-15 13:53:40', '2024-07-05 14:14:52', 131.9, 11.2, 216.23, 69.1, '李狗蛋', '李四格', 175);
INSERT INTO `info` VALUES (22, 3, 4, 532900, '罗湖区清水河一路576号', '测试数据的反馈信息', '2024-05-10 00:11:08', '2024-07-09 14:14:55', 302.05, 16.72, 405.2, 189.2, '李狗蛋', '李四格', 306);
INSERT INTO `info` VALUES (23, 3, 1, 370400, '罗湖区田贝一路854号', '测试数据的反馈信息', '2024-06-20 22:30:04', '2024-07-10 14:15:00', 17.9, 2.1, 40.71, 21.4, '李狗蛋', '李四格', 19);
INSERT INTO `info` VALUES (24, 3, 1, 445200, '锦江区红星路三段258号', '测试数据的反馈信息', '2024-05-27 06:12:00', '2024-07-11 14:15:03', 13.2, 0.75, 39.2, 9.21, '李狗蛋', '李四格', 16);
INSERT INTO `info` VALUES (25, 3, 5, 441200, '东城区东单王府井东街133号', '测试数据的反馈信息', '2024-05-07 14:29:08', '2024-07-12 14:15:06', 406.72, 21.42, 697.31, 301.25, '李狗蛋', '李四格', 571);
INSERT INTO `info` VALUES (26, 1, 1, 310118, '东泰五街509号', '测试数据的反馈信息', '2024-05-07 18:58:50', NULL, NULL, NULL, NULL, NULL, '袁江霞', NULL, NULL);
INSERT INTO `info` VALUES (27, 1, 1, 445200, '房山区岳琉路545号', '测试数据的反馈信息', '2024-06-12 13:06:29', NULL, NULL, NULL, NULL, NULL, '袁江霞', NULL, NULL);
INSERT INTO `info` VALUES (28, 2, 3, 310113, '乐丰六路242号', '测试数据的反馈信息', '2024-05-17 09:51:38', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (29, 2, 4, 510300, '成华区双庆路887号', '测试数据的反馈信息', '2024-06-25 11:12:47', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (30, 2, 2, 500108, '龙岗区布吉镇西环路432号', '测试数据的反馈信息', '2024-06-21 16:06:10', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (31, 2, 3, 330400, '锦江区人民南路四段839号', '测试数据的反馈信息', '2024-05-06 20:27:27', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (32, 2, 1, 620200, '紫马岭商圈中山五路866号', '测试数据的反馈信息', '2024-06-03 15:15:15', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (33, 2, 4, 341800, '龙岗区学园一巷296号', '测试数据的反馈信息', '2024-05-06 22:29:24', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (34, 2, 5, 110106, '西城区复兴门内大街249号', '测试数据的反馈信息', '2024-06-19 10:01:35', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (35, 2, 2, 441700, '朝阳区三里屯路13号', '测试数据的反馈信息', '2024-06-17 06:21:21', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (36, 2, 3, 330600, '成华区玉双路6号326号', '测试数据的反馈信息', '2024-05-13 11:01:07', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (37, 2, 6, 110106, '闵行区宾川路180号', '测试数据的反馈信息', '2024-06-28 11:03:20', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (38, 2, 1, 659004, '锦江区人民南路四段952号', '测试数据的反馈信息', '2024-06-07 01:58:29', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (39, 2, 3, 500236, '坑美十五巷443号', '测试数据的反馈信息', '2024-06-27 18:52:17', NULL, NULL, NULL, NULL, NULL, '袁江霞', '张三网', NULL);
INSERT INTO `info` VALUES (40, 2, 2, 370500, '白云区机场路棠苑街五巷507号', '测试数据的反馈信息', '2024-06-21 16:06:04', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (41, 2, 4, 131100, '成华区二仙桥东三路30号', '测试数据的反馈信息', '2024-05-13 03:49:24', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (42, 2, 2, 530100, '龙岗区学园一巷936号', '测试数据的反馈信息', '2024-05-13 08:31:45', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (43, 2, 3, 310109, '锦江区红星路三段521号', '测试数据的反馈信息', '2024-05-01 11:57:59', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (44, 2, 5, 140700, '延庆区028县道106号', '测试数据的反馈信息', '2024-05-20 22:57:35', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (45, 2, 1, 140800, '龙岗区布吉镇西环路466号', '测试数据的反馈信息', '2024-06-19 15:16:34', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (46, 2, 4, 440900, '天河区天河路297号', '测试数据的反馈信息', '2024-06-14 09:27:33', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (47, 2, 2, 420300, '福田区深南大道655号', '测试数据的反馈信息', '2024-05-31 14:25:46', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (48, 2, 3, 140800, '成华区玉双路6号544号', '测试数据的反馈信息', '2024-06-10 17:39:04', NULL, NULL, NULL, NULL, NULL, '袁江霞', '李四格', NULL);
INSERT INTO `info` VALUES (49, 1, 2, 120119, '成华区二仙桥东三路145号', '测试数据的反馈信息', '2024-06-12 08:33:30', '2024-07-14 14:22:06', 131.9, 11.2, 216.23, 69.1, '袁江霞', '张三网', 175);
INSERT INTO `info` VALUES (50, 1, 4, 371100, '坑美十五巷981号', '测试数据的反馈信息', '2024-06-05 20:50:16', '2024-07-15 14:22:10', 302.05, 16.72, 405.2, 189.2, '袁江霞', '张三网', 306);
INSERT INTO `info` VALUES (51, 1, 1, 532600, '浦东新区健祥路203号', '测试数据的反馈信息', '2024-06-20 07:25:46', '2024-07-13 14:21:35', 13.2, 0.75, 39.2, 9.21, '袁江霞', '李四格', 16);
INSERT INTO `info` VALUES (52, 1, 5, 450600, '珊瑚路554号', '测试数据的反馈信息', '2024-06-25 22:50:19', '2024-07-14 14:21:39', 406.72, 21.42, 697.31, 301.25, '袁江霞', '李四格', 571);

-- ----------------------------
-- Table structure for info_with_inspector
-- ----------------------------
DROP TABLE IF EXISTS `info_with_inspector`;
CREATE TABLE `info_with_inspector`  (
  `i_id` int NOT NULL COMMENT '网格员负责事件id',
  `info_id` int NOT NULL COMMENT '网格员负责信息id',
  `inspector_id` int NOT NULL COMMENT '网格员id',
  `isdel` int NOT NULL DEFAULT 0 COMMENT '软删除\r\n0是未删除\r\n1是已删除',
  PRIMARY KEY (`i_id`) USING BTREE,
  INDEX `info_id`(`info_id` ASC) USING BTREE,
  INDEX `inspector_id`(`inspector_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info_with_inspector
-- ----------------------------
INSERT INTO `info_with_inspector` VALUES (1, 4, 1, 0);
INSERT INTO `info_with_inspector` VALUES (2, 5, 1, 0);
INSERT INTO `info_with_inspector` VALUES (3, 6, 1, 0);
INSERT INTO `info_with_inspector` VALUES (4, 7, 1, 0);
INSERT INTO `info_with_inspector` VALUES (5, 14, 1, 0);
INSERT INTO `info_with_inspector` VALUES (6, 15, 1, 0);
INSERT INTO `info_with_inspector` VALUES (7, 16, 1, 0);
INSERT INTO `info_with_inspector` VALUES (8, 17, 1, 0);
INSERT INTO `info_with_inspector` VALUES (9, 18, 1, 0);
INSERT INTO `info_with_inspector` VALUES (10, 19, 1, 0);
INSERT INTO `info_with_inspector` VALUES (11, 28, 1, 0);
INSERT INTO `info_with_inspector` VALUES (12, 29, 1, 0);
INSERT INTO `info_with_inspector` VALUES (13, 30, 1, 0);
INSERT INTO `info_with_inspector` VALUES (14, 31, 1, 0);
INSERT INTO `info_with_inspector` VALUES (15, 32, 1, 0);
INSERT INTO `info_with_inspector` VALUES (16, 33, 1, 0);
INSERT INTO `info_with_inspector` VALUES (17, 34, 1, 0);
INSERT INTO `info_with_inspector` VALUES (18, 35, 1, 0);
INSERT INTO `info_with_inspector` VALUES (19, 36, 1, 0);
INSERT INTO `info_with_inspector` VALUES (20, 37, 1, 0);
INSERT INTO `info_with_inspector` VALUES (21, 38, 1, 0);
INSERT INTO `info_with_inspector` VALUES (22, 39, 1, 0);
INSERT INTO `info_with_inspector` VALUES (23, 49, 1, 0);
INSERT INTO `info_with_inspector` VALUES (24, 50, 1, 0);
INSERT INTO `info_with_inspector` VALUES (25, 8, 2, 0);
INSERT INTO `info_with_inspector` VALUES (26, 9, 2, 0);
INSERT INTO `info_with_inspector` VALUES (27, 10, 2, 0);
INSERT INTO `info_with_inspector` VALUES (28, 11, 2, 0);
INSERT INTO `info_with_inspector` VALUES (29, 12, 2, 0);
INSERT INTO `info_with_inspector` VALUES (30, 13, 2, 0);
INSERT INTO `info_with_inspector` VALUES (31, 20, 2, 0);
INSERT INTO `info_with_inspector` VALUES (32, 21, 2, 0);
INSERT INTO `info_with_inspector` VALUES (33, 22, 2, 0);
INSERT INTO `info_with_inspector` VALUES (34, 23, 2, 0);
INSERT INTO `info_with_inspector` VALUES (35, 24, 2, 0);
INSERT INTO `info_with_inspector` VALUES (36, 25, 2, 0);
INSERT INTO `info_with_inspector` VALUES (37, 40, 2, 0);
INSERT INTO `info_with_inspector` VALUES (38, 41, 2, 0);
INSERT INTO `info_with_inspector` VALUES (39, 42, 2, 0);
INSERT INTO `info_with_inspector` VALUES (40, 43, 2, 0);
INSERT INTO `info_with_inspector` VALUES (41, 44, 2, 0);
INSERT INTO `info_with_inspector` VALUES (42, 45, 2, 0);
INSERT INTO `info_with_inspector` VALUES (43, 46, 2, 0);
INSERT INTO `info_with_inspector` VALUES (44, 47, 2, 0);
INSERT INTO `info_with_inspector` VALUES (45, 48, 2, 0);
INSERT INTO `info_with_inspector` VALUES (46, 51, 2, 0);
INSERT INTO `info_with_inspector` VALUES (47, 52, 2, 0);

-- ----------------------------
-- Table structure for info_with_supervisor
-- ----------------------------
DROP TABLE IF EXISTS `info_with_supervisor`;
CREATE TABLE `info_with_supervisor`  (
  `s_id` int NOT NULL COMMENT '公众监督员负责事件id',
  `info_id` int NOT NULL COMMENT '公众监督员负责信息id',
  `supervisor_id` int NOT NULL COMMENT '公众监督员id',
  `isdel` int NOT NULL DEFAULT 0 COMMENT '软删除\r\n0是未删除\r\n1是已删除',
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `infos_id`(`info_id` ASC) USING BTREE,
  INDEX `supervisor_id`(`supervisor_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info_with_supervisor
-- ----------------------------
INSERT INTO `info_with_supervisor` VALUES (1, 1, 1, 1);
INSERT INTO `info_with_supervisor` VALUES (2, 2, 2, 1);
INSERT INTO `info_with_supervisor` VALUES (3, 3, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (4, 4, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (5, 5, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (6, 6, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (7, 7, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (8, 8, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (9, 9, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (10, 10, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (11, 11, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (12, 12, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (13, 13, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (14, 14, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (15, 15, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (16, 16, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (17, 17, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (18, 18, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (19, 19, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (20, 20, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (21, 21, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (22, 22, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (23, 23, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (24, 24, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (25, 25, 1, 0);
INSERT INTO `info_with_supervisor` VALUES (26, 26, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (27, 27, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (28, 28, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (29, 29, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (30, 30, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (31, 31, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (32, 32, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (33, 33, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (34, 34, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (35, 35, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (36, 36, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (37, 37, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (38, 38, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (39, 39, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (40, 40, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (41, 41, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (42, 42, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (43, 43, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (44, 44, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (45, 45, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (46, 46, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (47, 47, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (48, 48, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (49, 49, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (50, 50, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (51, 51, 2, 0);
INSERT INTO `info_with_supervisor` VALUES (52, 52, 2, 0);

-- ----------------------------
-- Table structure for inspector
-- ----------------------------
DROP TABLE IF EXISTS `inspector`;
CREATE TABLE `inspector`  (
  `inspector_id` int NOT NULL AUTO_INCREMENT COMMENT '网格员编号',
  `inspector_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员登录编码',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员登录密码',
  `salt` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网格员盐值',
  `tel_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员电话',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员姓名',
  `city_code` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员所负责的城市代码',
  `isdel` int NULL DEFAULT NULL COMMENT '软删除\r\n0 能使用\r\n1 已删除',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`inspector_id`) USING BTREE,
  INDEX `city_code_inspector`(`city_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inspector
-- ----------------------------
INSERT INTO `inspector` VALUES (1, 'inspector1', '565bc401ba71ff4e0a0d66f2d55f0619', 'sMdNLTPMSrcWTxJXcBVvRQ==', '15854620154', '张三网', '110105', 0, NULL);
INSERT INTO `inspector` VALUES (2, 'inspector2', '75ba5fb93229866ced015a7cc1493f59', 'EzofMbHKWCGH1qioP+lFvg==', '18620147895', '李四格', '710001', 0, NULL);

-- ----------------------------
-- Table structure for lock_table
-- ----------------------------
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table`  (
  `row_key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `xid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `transaction_id` bigint NULL DEFAULT NULL,
  `branch_id` bigint NOT NULL,
  `resource_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `table_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pk` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '0:locked ,1:rollbacking',
  `gmt_create` datetime NULL DEFAULT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`row_key`) USING BTREE,
  INDEX `idx_status`(`status` ASC) USING BTREE,
  INDEX `idx_branch_id`(`branch_id` ASC) USING BTREE,
  INDEX `idx_xid_and_branch_id`(`xid` ASC, `branch_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lock_table
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `province_id` int NOT NULL COMMENT '省id',
  `province_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省名',
  `simple_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省简称',
  `index` int NULL DEFAULT NULL COMMENT 'index排名',
  PRIMARY KEY (`province_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (110000, '北京市', '京', 1);
INSERT INTO `province` VALUES (120000, '天津市', '津', 2);
INSERT INTO `province` VALUES (130000, '河北省', '冀', 3);
INSERT INTO `province` VALUES (140000, '山西省', '晋', 4);
INSERT INTO `province` VALUES (150000, '内蒙古自治区', '蒙', 5);
INSERT INTO `province` VALUES (210000, '辽宁省', '辽', 6);
INSERT INTO `province` VALUES (220000, '吉林省', '吉', 7);
INSERT INTO `province` VALUES (230000, '黑龙江省', '黑', 8);
INSERT INTO `province` VALUES (310000, '上海市', '沪', 9);
INSERT INTO `province` VALUES (320000, '江苏省', '苏', 10);
INSERT INTO `province` VALUES (330000, '浙江省', '浙', 11);
INSERT INTO `province` VALUES (340000, '安徽省', '皖', 12);
INSERT INTO `province` VALUES (350000, '福建省', '闽', 13);
INSERT INTO `province` VALUES (360000, '江西省', '赣', 14);
INSERT INTO `province` VALUES (370000, '山东省', '鲁', 15);
INSERT INTO `province` VALUES (410000, '河南省', '豫', 16);
INSERT INTO `province` VALUES (420000, '湖北省', '鄂', 17);
INSERT INTO `province` VALUES (430000, '湖南省', '湘', 18);
INSERT INTO `province` VALUES (440000, '广东省', '粤', 19);
INSERT INTO `province` VALUES (450000, '广西壮族自治区', '桂', 20);
INSERT INTO `province` VALUES (460000, '海南省', '琼', 21);
INSERT INTO `province` VALUES (500000, '重庆市', '渝', 22);
INSERT INTO `province` VALUES (510000, '四川省', '川', 23);
INSERT INTO `province` VALUES (520000, '贵州省', '贵', 24);
INSERT INTO `province` VALUES (530000, '云南省', '云', 25);
INSERT INTO `province` VALUES (540000, '西藏自治区', '藏', 26);
INSERT INTO `province` VALUES (610000, '陕西省', '陕', 27);
INSERT INTO `province` VALUES (620000, '甘肃省', '甘', 28);
INSERT INTO `province` VALUES (630000, '青海省', '青', 29);
INSERT INTO `province` VALUES (640000, '宁夏回族自治区', '宁', 30);
INSERT INTO `province` VALUES (650000, '新疆维吾尔自治区', '新', 31);
INSERT INTO `province` VALUES (710000, '台湾省', '台', 32);
INSERT INTO `province` VALUES (810000, '香港特别行政区', '港', 33);
INSERT INTO `province` VALUES (820000, '澳门特别行政区', '澳', 34);

-- ----------------------------
-- Table structure for supervisor
-- ----------------------------
DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE `supervisor`  (
  `supervisor_id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公众监督员id',
  `tel_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '公众监督员编号（手机号码）',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员登录密码',
  `salt` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员盐值',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员真实姓名',
  `birthday` date NOT NULL COMMENT '公众监督员生日日期',
  `sex` int NOT NULL DEFAULT 1 COMMENT '公众监督员性别（1：男；0：女）',
  `age` int NOT NULL COMMENT '公众监督员年龄',
  `isdel` int NULL DEFAULT 0 COMMENT '软删除\r\n0 能使用\r\n1 已删除',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`supervisor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supervisor
-- ----------------------------
INSERT INTO `supervisor` VALUES (1, '15369954210', '74a0833b7f93e56e459d49370451a5e9', 'i9uDDyOybBWWJzpN9/1dkg==', '李狗蛋', '1994-07-05', 1, 30, 0, NULL);
INSERT INTO `supervisor` VALUES (2, '18625478544', '5bdb2bc2c2de05c80968e275345c0c6d', 'Gg8EabaPfrCNeSTW7eJCQg==', '袁江霞', '2004-03-01', 0, 20, 0, NULL);

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_id` bigint NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid` ASC, `branch_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
