create database sxtbbs;
use sxtbbs;

-- 省份表
create table bbsprovince (
	proid varchar(6) primary key,
    proname varchar(40) not null
);

-- 城市表
create table bbscity (
	citid varchar(6) primary key,
    citname varchar(50) not null,
    father varchar(6) not null,
    
    foreign key (father) references bbsprovince(proid)
);

-- 用户表
create table bbsuser (
	uname varchar(30) primary key,
    upass varchar(50) not null, -- 需要加密
    uproc varchar(6),
    ucity varchar(6),
    usex varchar(2) not null default '男',
    uphoto varchar(100) null,  -- 头像图片的地址/路径
    uregdate date not null,
    uregtime time not null,
    uisadmin varchar(1) not null default '0', -- 是否管理员 0用户 1管理员
    uflag varchar(1) null default '0',  -- 是否被封闭(禁言) 0可发言 1被禁言
    
    foreign key (uproc) references bbsprovince(proid),
    foreign key (ucity) references bbscity(citid)
);

-- 板块表
create table bbsboard (
	boaid varchar(2) primary key, -- 板块编号
    boaname varchar(50) not null,
    boauname varchar(30) null,  -- 版主
    boadate date not null,
    boatime time not null,
    boaflag varchar(1) null default '1', -- 是否启用 0未启用 1启用
    
    foreign key (boauname) references bbsuser(uname)
);

-- 子版块表
create table bbschildboard (
	cboid varchar(3) primary key,
    cboname varchar(100) not null,
    boaid varchar(2) not null,
    cbodate date not null,
    cbotime time not null,
    cboflag varchar(1) null default '1', -- 是否启用 0未启用 1启用
    
    foreign key (boaid) references bbsboard(boaid)
);

-- 主(发)贴表
create table bbsblog (
	bloid int primary key auto_increment,
    blotitle varchar(100) not null,
    blocontent varchar(2000) not null,
    bloinputdate date not null,
    bloinputtime time not null,
    blolastmodifydate date not null,
    blolastmodifytime time not null,
    uname varchar(30) not null,
    cboid varchar(3) not null,
    bloisdelete varchar(1) null default '0', -- 是否删除 0未删除 1已删除
    
    foreign key (uname) references bbsuser(uname),
    foreign key (cboid) references bbschildboard(cboid)
);

-- 跟帖(回复)表
create table bbsreplyblog (
	rblid int primary key auto_increment,
    rblcontent varchar(2000) not null,
    rblreplydate date not null,
    rblreplytime time not null,
    rblmodifydate date not null,
    rblmodifytime time not null,
    uname varchar(30), -- 回帖人
    bloid int,
    rblisdelete varchar(1) null default '0', -- 是否删除 0未删除 1已删除
    
    foreign key (uname) references bbsuser(uname),
    foreign key (bloid) references bbsblog(bloid)
);


/*省数据*/
INSERT INTO bbsprovince VALUES ('110000','北京市');
INSERT INTO bbsprovince VALUES ('120000','天津市');
INSERT INTO bbsprovince VALUES ('130000','河北省');
INSERT INTO bbsprovince VALUES ('140000','山西省');
INSERT INTO bbsprovince VALUES ('150000','内蒙古自治区');
INSERT INTO bbsprovince VALUES ('210000','辽宁省');
INSERT INTO bbsprovince VALUES ('220000','吉林省');
INSERT INTO bbsprovince VALUES ('230000','黑龙江省');
INSERT INTO bbsprovince VALUES ('310000','上海市');
INSERT INTO bbsprovince VALUES ('320000','江苏省');
INSERT INTO bbsprovince VALUES ('330000','浙江省');
INSERT INTO bbsprovince VALUES ('340000','安徽省');
INSERT INTO bbsprovince VALUES ('350000','福建省');
INSERT INTO bbsprovince VALUES ('360000','江西省');
INSERT INTO bbsprovince VALUES ('370000','山东省');
INSERT INTO bbsprovince VALUES ('410000','河南省');
INSERT INTO bbsprovince VALUES ('420000','湖北省');
INSERT INTO bbsprovince VALUES ('430000','湖南省');
INSERT INTO bbsprovince VALUES ('440000','广东省');
INSERT INTO bbsprovince VALUES ('450000','广西壮族自治区');
INSERT INTO bbsprovince VALUES ('460000','海南省');
INSERT INTO bbsprovince VALUES ('500000','重庆市');
INSERT INTO bbsprovince VALUES ('510000','四川省');
INSERT INTO bbsprovince VALUES ('520000','贵州省');
INSERT INTO bbsprovince VALUES ('530000','云南省');
INSERT INTO bbsprovince VALUES ('540000','西藏自治区');
INSERT INTO bbsprovince VALUES ('610000','陕西省');
INSERT INTO bbsprovince VALUES ('620000','甘肃省');
INSERT INTO bbsprovince VALUES ('630000','青海省');
INSERT INTO bbsprovince VALUES ('640000','宁夏回族自治区');
INSERT INTO bbsprovince VALUES ('650000','新疆维吾尔自治区');
INSERT INTO bbsprovince VALUES ('710000','台湾省');
INSERT INTO bbsprovince VALUES ('810000','香港特别行政区');
INSERT INTO bbsprovince VALUES ('820000','澳门特别行政区');

/*市数据*/
INSERT INTO bbscity VALUES ('110100','市辖区','110000');
INSERT INTO bbscity VALUES ('110200','县','110000');
INSERT INTO bbscity VALUES ('120100','市辖区','120000');
INSERT INTO bbscity VALUES ('120200','县','120000');
INSERT INTO bbscity VALUES ('130100','石家庄市','130000');
INSERT INTO bbscity VALUES ('130200','唐山市','130000');
INSERT INTO bbscity VALUES ('130300','秦皇岛市','130000');
INSERT INTO bbscity VALUES ('130400','邯郸市','130000');
INSERT INTO bbscity VALUES ('130500','邢台市','130000');
INSERT INTO bbscity VALUES ('130600','保定市','130000');
INSERT INTO bbscity VALUES ('130700','张家口市','130000');
INSERT INTO bbscity VALUES ('130800','承德市','130000');
INSERT INTO bbscity VALUES ('130900','沧州市','130000');
INSERT INTO bbscity VALUES ('131000','廊坊市','130000');
INSERT INTO bbscity VALUES ('131100','衡水市','130000');
INSERT INTO bbscity VALUES ('140100','太原市','140000');
INSERT INTO bbscity VALUES ('140200','大同市','140000');
INSERT INTO bbscity VALUES ('140300','阳泉市','140000');
INSERT INTO bbscity VALUES ('140400','长治市','140000');
INSERT INTO bbscity VALUES ('140500','晋城市','140000');
INSERT INTO bbscity VALUES ('140600','朔州市','140000');
INSERT INTO bbscity VALUES ('140700','晋中市','140000');
INSERT INTO bbscity VALUES ('140800','运城市','140000');
INSERT INTO bbscity VALUES ('140900','忻州市','140000');
INSERT INTO bbscity VALUES ('141000','临汾市','140000');
INSERT INTO bbscity VALUES ('141100','吕梁市','140000');
INSERT INTO bbscity VALUES ('150100','呼和浩特市','150000');
INSERT INTO bbscity VALUES ('150200','包头市','150000');
INSERT INTO bbscity VALUES ('150300','乌海市','150000');
INSERT INTO bbscity VALUES ('150400','赤峰市','150000');
INSERT INTO bbscity VALUES ('150500','通辽市','150000');
INSERT INTO bbscity VALUES ('150600','鄂尔多斯市','150000');
INSERT INTO bbscity VALUES ('150700','呼伦贝尔市','150000');
INSERT INTO bbscity VALUES ('150800','巴彦淖尔市','150000');
INSERT INTO bbscity VALUES ('150900','乌兰察布市','150000');
INSERT INTO bbscity VALUES ('152200','兴安盟','150000');
INSERT INTO bbscity VALUES ('152500','锡林郭勒盟','150000');
INSERT INTO bbscity VALUES ('152900','阿拉善盟','150000');
INSERT INTO bbscity VALUES ('210100','沈阳市','210000');
INSERT INTO bbscity VALUES ('210200','大连市','210000');
INSERT INTO bbscity VALUES ('210300','鞍山市','210000');
INSERT INTO bbscity VALUES ('210400','抚顺市','210000');
INSERT INTO bbscity VALUES ('210500','本溪市','210000');
INSERT INTO bbscity VALUES ('210600','丹东市','210000');
INSERT INTO bbscity VALUES ('210700','锦州市','210000');
INSERT INTO bbscity VALUES ('210800','营口市','210000');
INSERT INTO bbscity VALUES ('210900','阜新市','210000');
INSERT INTO bbscity VALUES ('211000','辽阳市','210000');
INSERT INTO bbscity VALUES ('211100','盘锦市','210000');
INSERT INTO bbscity VALUES ('211200','铁岭市','210000');
INSERT INTO bbscity VALUES ('211300','朝阳市','210000');
INSERT INTO bbscity VALUES ('211400','葫芦岛市','210000');
INSERT INTO bbscity VALUES ('220100','长春市','220000');
INSERT INTO bbscity VALUES ('220200','吉林市','220000');
INSERT INTO bbscity VALUES ('220300','四平市','220000');
INSERT INTO bbscity VALUES ('220400','辽源市','220000');
INSERT INTO bbscity VALUES ('220500','通化市','220000');
INSERT INTO bbscity VALUES ('220600','白山市','220000');
INSERT INTO bbscity VALUES ('220700','松原市','220000');
INSERT INTO bbscity VALUES ('220800','白城市','220000');
INSERT INTO bbscity VALUES ('222400','延边朝鲜族自治州','220000');
INSERT INTO bbscity VALUES ('230100','哈尔滨市','230000');
INSERT INTO bbscity VALUES ('230200','齐齐哈尔市','230000');
INSERT INTO bbscity VALUES ('230300','鸡西市','230000');
INSERT INTO bbscity VALUES ('230400','鹤岗市','230000');
INSERT INTO bbscity VALUES ('230500','双鸭山市','230000');
INSERT INTO bbscity VALUES ('230600','大庆市','230000');
INSERT INTO bbscity VALUES ('230700','伊春市','230000');
INSERT INTO bbscity VALUES ('230800','佳木斯市','230000');
INSERT INTO bbscity VALUES ('230900','七台河市','230000');
INSERT INTO bbscity VALUES ('231000','牡丹江市','230000');
INSERT INTO bbscity VALUES ('231100','黑河市','230000');
INSERT INTO bbscity VALUES ('231200','绥化市','230000');
INSERT INTO bbscity VALUES ('232700','大兴安岭地区','230000');
INSERT INTO bbscity VALUES ('310100','市辖区','310000');
INSERT INTO bbscity VALUES ('310200','县','310000');
INSERT INTO bbscity VALUES ('320100','南京市','320000');
INSERT INTO bbscity VALUES ('320200','无锡市','320000');
INSERT INTO bbscity VALUES ('320300','徐州市','320000');
INSERT INTO bbscity VALUES ('320400','常州市','320000');
INSERT INTO bbscity VALUES ('320500','苏州市','320000');
INSERT INTO bbscity VALUES ('320600','南通市','320000');
INSERT INTO bbscity VALUES ('320700','连云港市','320000');
INSERT INTO bbscity VALUES ('320800','淮安市','320000');
INSERT INTO bbscity VALUES ('320900','盐城市','320000');
INSERT INTO bbscity VALUES ('321000','扬州市','320000');
INSERT INTO bbscity VALUES ('321100','镇江市','320000');
INSERT INTO bbscity VALUES ('321200','泰州市','320000');
INSERT INTO bbscity VALUES ('321300','宿迁市','320000');
INSERT INTO bbscity VALUES ('330100','杭州市','330000');
INSERT INTO bbscity VALUES ('330200','宁波市','330000');
INSERT INTO bbscity VALUES ('330300','温州市','330000');
INSERT INTO bbscity VALUES ('330400','嘉兴市','330000');
INSERT INTO bbscity VALUES ('330500','湖州市','330000');
INSERT INTO bbscity VALUES ('330600','绍兴市','330000');
INSERT INTO bbscity VALUES ('330700','金华市','330000');
INSERT INTO bbscity VALUES ('330800','衢州市','330000');
INSERT INTO bbscity VALUES ('330900','舟山市','330000');
INSERT INTO bbscity VALUES ('331000','台州市','330000');
INSERT INTO bbscity VALUES ('331100','丽水市','330000');
INSERT INTO bbscity VALUES ('340100','合肥市','340000');
INSERT INTO bbscity VALUES ('340200','芜湖市','340000');
INSERT INTO bbscity VALUES ('340300','蚌埠市','340000');
INSERT INTO bbscity VALUES ('340400','淮南市','340000');
INSERT INTO bbscity VALUES ('340500','马鞍山市','340000');
INSERT INTO bbscity VALUES ('340600','淮北市','340000');
INSERT INTO bbscity VALUES ('340700','铜陵市','340000');
INSERT INTO bbscity VALUES ('340800','安庆市','340000');
INSERT INTO bbscity VALUES ('341000','黄山市','340000');
INSERT INTO bbscity VALUES ('341100','滁州市','340000');
INSERT INTO bbscity VALUES ('341200','阜阳市','340000');
INSERT INTO bbscity VALUES ('341300','宿州市','340000');
INSERT INTO bbscity VALUES ('341400','巢湖市','340000');
INSERT INTO bbscity VALUES ('341500','六安市','340000');
INSERT INTO bbscity VALUES ('341600','亳州市','340000');
INSERT INTO bbscity VALUES ('341700','池州市','340000');
INSERT INTO bbscity VALUES ('341800','宣城市','340000');
INSERT INTO bbscity VALUES ('350100','福州市','350000');
INSERT INTO bbscity VALUES ('350200','厦门市','350000');
INSERT INTO bbscity VALUES ('350300','莆田市','350000');
INSERT INTO bbscity VALUES ('350400','三明市','350000');
INSERT INTO bbscity VALUES ('350500','泉州市','350000');
INSERT INTO bbscity VALUES ('350600','漳州市','350000');
INSERT INTO bbscity VALUES ('350700','南平市','350000');
INSERT INTO bbscity VALUES ('350800','龙岩市','350000');
INSERT INTO bbscity VALUES ('350900','宁德市','350000');
INSERT INTO bbscity VALUES ('360100','南昌市','360000');
INSERT INTO bbscity VALUES ('360200','景德镇市','360000');
INSERT INTO bbscity VALUES ('360300','萍乡市','360000');
INSERT INTO bbscity VALUES ('360400','九江市','360000');
INSERT INTO bbscity VALUES ('360500','新余市','360000');
INSERT INTO bbscity VALUES ('360600','鹰潭市','360000');
INSERT INTO bbscity VALUES ('360700','赣州市','360000');
INSERT INTO bbscity VALUES ('360800','吉安市','360000');
INSERT INTO bbscity VALUES ('360900','宜春市','360000');
INSERT INTO bbscity VALUES ('361000','抚州市','360000');
INSERT INTO bbscity VALUES ('361100','上饶市','360000');
INSERT INTO bbscity VALUES ('370100','济南市','370000');
INSERT INTO bbscity VALUES ('370200','青岛市','370000');
INSERT INTO bbscity VALUES ('370300','淄博市','370000');
INSERT INTO bbscity VALUES ('370400','枣庄市','370000');
INSERT INTO bbscity VALUES ('370500','东营市','370000');
INSERT INTO bbscity VALUES ('370600','烟台市','370000');
INSERT INTO bbscity VALUES ('370700','潍坊市','370000');
INSERT INTO bbscity VALUES ('370800','济宁市','370000');
INSERT INTO bbscity VALUES ('370900','泰安市','370000');
INSERT INTO bbscity VALUES ('371000','威海市','370000');
INSERT INTO bbscity VALUES ('371100','日照市','370000');
INSERT INTO bbscity VALUES ('371200','莱芜市','370000');
INSERT INTO bbscity VALUES ('371300','临沂市','370000');
INSERT INTO bbscity VALUES ('371400','德州市','370000');
INSERT INTO bbscity VALUES ('371500','聊城市','370000');
INSERT INTO bbscity VALUES ('371600','滨州市','370000');
INSERT INTO bbscity VALUES ('371700','荷泽市','370000');
INSERT INTO bbscity VALUES ('410100','郑州市','410000');
INSERT INTO bbscity VALUES ('410200','开封市','410000');
INSERT INTO bbscity VALUES ('410300','洛阳市','410000');
INSERT INTO bbscity VALUES ('410400','平顶山市','410000');
INSERT INTO bbscity VALUES ('410500','安阳市','410000');
INSERT INTO bbscity VALUES ('410600','鹤壁市','410000');
INSERT INTO bbscity VALUES ('410700','新乡市','410000');
INSERT INTO bbscity VALUES ('410800','焦作市','410000');
INSERT INTO bbscity VALUES ('410900','濮阳市','410000');
INSERT INTO bbscity VALUES ('411000','许昌市','410000');
INSERT INTO bbscity VALUES ('411100','漯河市','410000');
INSERT INTO bbscity VALUES ('411200','三门峡市','410000');
INSERT INTO bbscity VALUES ('411300','南阳市','410000');
INSERT INTO bbscity VALUES ('411400','商丘市','410000');
INSERT INTO bbscity VALUES ('411500','信阳市','410000');
INSERT INTO bbscity VALUES ('411600','周口市','410000');
INSERT INTO bbscity VALUES ('411700','驻马店市','410000');
INSERT INTO bbscity VALUES ('420100','武汉市','420000');
INSERT INTO bbscity VALUES ('420200','黄石市','420000');
INSERT INTO bbscity VALUES ('420300','十堰市','420000');
INSERT INTO bbscity VALUES ('420500','宜昌市','420000');
INSERT INTO bbscity VALUES ('420600','襄樊市','420000');
INSERT INTO bbscity VALUES ('420700','鄂州市','420000');
INSERT INTO bbscity VALUES ('420800','荆门市','420000');
INSERT INTO bbscity VALUES ('420900','孝感市','420000');
INSERT INTO bbscity VALUES ('421000','荆州市','420000');
INSERT INTO bbscity VALUES ('421100','黄冈市','420000');
INSERT INTO bbscity VALUES ('421200','咸宁市','420000');
INSERT INTO bbscity VALUES ('421300','随州市','420000');
INSERT INTO bbscity VALUES ('422800','恩施土家族苗族自治州','420000');
INSERT INTO bbscity VALUES ('429000','省直辖行政单位','420000');
INSERT INTO bbscity VALUES ('430100','长沙市','430000');
INSERT INTO bbscity VALUES ('430200','株洲市','430000');
INSERT INTO bbscity VALUES ('430300','湘潭市','430000');
INSERT INTO bbscity VALUES ('430400','衡阳市','430000');
INSERT INTO bbscity VALUES ('430500','邵阳市','430000');
INSERT INTO bbscity VALUES ('430600','岳阳市','430000');
INSERT INTO bbscity VALUES ('430700','常德市','430000');
INSERT INTO bbscity VALUES ('430800','张家界市','430000');
INSERT INTO bbscity VALUES ('430900','益阳市','430000');
INSERT INTO bbscity VALUES ('431000','郴州市','430000');
INSERT INTO bbscity VALUES ('431100','永州市','430000');
INSERT INTO bbscity VALUES ('431200','怀化市','430000');
INSERT INTO bbscity VALUES ('431300','娄底市','430000');
INSERT INTO bbscity VALUES ('433100','湘西土家族苗族自治州','430000');
INSERT INTO bbscity VALUES ('440100','广州市','440000');
INSERT INTO bbscity VALUES ('440200','韶关市','440000');
INSERT INTO bbscity VALUES ('440300','深圳市','440000');
INSERT INTO bbscity VALUES ('440400','珠海市','440000');
INSERT INTO bbscity VALUES ('440500','汕头市','440000');
INSERT INTO bbscity VALUES ('440600','佛山市','440000');
INSERT INTO bbscity VALUES ('440700','江门市','440000');
INSERT INTO bbscity VALUES ('440800','湛江市','440000');
INSERT INTO bbscity VALUES ('440900','茂名市','440000');
INSERT INTO bbscity VALUES ('441200','肇庆市','440000');
INSERT INTO bbscity VALUES ('441300','惠州市','440000');
INSERT INTO bbscity VALUES ('441400','梅州市','440000');
INSERT INTO bbscity VALUES ('441500','汕尾市','440000');
INSERT INTO bbscity VALUES ('441600','河源市','440000');
INSERT INTO bbscity VALUES ('441700','阳江市','440000');
INSERT INTO bbscity VALUES ('441800','清远市','440000');
INSERT INTO bbscity VALUES ('441900','东莞市','440000');
INSERT INTO bbscity VALUES ('442000','中山市','440000');
INSERT INTO bbscity VALUES ('445100','潮州市','440000');
INSERT INTO bbscity VALUES ('445200','揭阳市','440000');
INSERT INTO bbscity VALUES ('445300','云浮市','440000');
INSERT INTO bbscity VALUES ('450100','南宁市','450000');
INSERT INTO bbscity VALUES ('450200','柳州市','450000');
INSERT INTO bbscity VALUES ('450300','桂林市','450000');
INSERT INTO bbscity VALUES ('450400','梧州市','450000');
INSERT INTO bbscity VALUES ('450500','北海市','450000');
INSERT INTO bbscity VALUES ('450600','防城港市','450000');
INSERT INTO bbscity VALUES ('450700','钦州市','450000');
INSERT INTO bbscity VALUES ('450800','贵港市','450000');
INSERT INTO bbscity VALUES ('450900','玉林市','450000');
INSERT INTO bbscity VALUES ('451000','百色市','450000');
INSERT INTO bbscity VALUES ('451100','贺州市','450000');
INSERT INTO bbscity VALUES ('451200','河池市','450000');
INSERT INTO bbscity VALUES ('451300','来宾市','450000');
INSERT INTO bbscity VALUES ('451400','崇左市','450000');
INSERT INTO bbscity VALUES ('460100','海口市','460000');
INSERT INTO bbscity VALUES ('460200','三亚市','460000');
INSERT INTO bbscity VALUES ('469000','省直辖县级行政单位','460000');
INSERT INTO bbscity VALUES ('500100','市辖区','500000');
INSERT INTO bbscity VALUES ('500200','县','500000');
INSERT INTO bbscity VALUES ('500300','市','500000');
INSERT INTO bbscity VALUES ('510100','成都市','510000');
INSERT INTO bbscity VALUES ('510300','自贡市','510000');
INSERT INTO bbscity VALUES ('510400','攀枝花市','510000');
INSERT INTO bbscity VALUES ('510500','泸州市','510000');
INSERT INTO bbscity VALUES ('510600','德阳市','510000');
INSERT INTO bbscity VALUES ('510700','绵阳市','510000');
INSERT INTO bbscity VALUES ('510800','广元市','510000');
INSERT INTO bbscity VALUES ('510900','遂宁市','510000');
INSERT INTO bbscity VALUES ('511000','内江市','510000');
INSERT INTO bbscity VALUES ('511100','乐山市','510000');
INSERT INTO bbscity VALUES ('511300','南充市','510000');
INSERT INTO bbscity VALUES ('511400','眉山市','510000');
INSERT INTO bbscity VALUES ('511500','宜宾市','510000');
INSERT INTO bbscity VALUES ('511600','广安市','510000');
INSERT INTO bbscity VALUES ('511700','达州市','510000');
INSERT INTO bbscity VALUES ('511800','雅安市','510000');
INSERT INTO bbscity VALUES ('511900','巴中市','510000');
INSERT INTO bbscity VALUES ('512000','资阳市','510000');
INSERT INTO bbscity VALUES ('513200','阿坝藏族羌族自治州','510000');
INSERT INTO bbscity VALUES ('513300','甘孜藏族自治州','510000');
INSERT INTO bbscity VALUES ('513400','凉山彝族自治州','510000');
INSERT INTO bbscity VALUES ('520100','贵阳市','520000');
INSERT INTO bbscity VALUES ('520200','六盘水市','520000');
INSERT INTO bbscity VALUES ('520300','遵义市','520000');
INSERT INTO bbscity VALUES ('520400','安顺市','520000');
INSERT INTO bbscity VALUES ('522200','铜仁地区','520000');
INSERT INTO bbscity VALUES ('522300','黔西南布依族苗族自治州','520000');
INSERT INTO bbscity VALUES ('522400','毕节地区','520000');
INSERT INTO bbscity VALUES ('522600','黔东南苗族侗族自治州','520000');
INSERT INTO bbscity VALUES ('522700','黔南布依族苗族自治州','520000');
INSERT INTO bbscity VALUES ('530100','昆明市','530000');
INSERT INTO bbscity VALUES ('530300','曲靖市','530000');
INSERT INTO bbscity VALUES ('530400','玉溪市','530000');
INSERT INTO bbscity VALUES ('530500','保山市','530000');
INSERT INTO bbscity VALUES ('530600','昭通市','530000');
INSERT INTO bbscity VALUES ('530700','丽江市','530000');
INSERT INTO bbscity VALUES ('530800','思茅市','530000');
INSERT INTO bbscity VALUES ('530900','临沧市','530000');
INSERT INTO bbscity VALUES ('532300','楚雄彝族自治州','530000');
INSERT INTO bbscity VALUES ('532500','红河哈尼族彝族自治州','530000');
INSERT INTO bbscity VALUES ('532600','文山壮族苗族自治州','530000');
INSERT INTO bbscity VALUES ('532800','西双版纳傣族自治州','530000');
INSERT INTO bbscity VALUES ('532900','大理白族自治州','530000');
INSERT INTO bbscity VALUES ('533100','德宏傣族景颇族自治州','530000');
INSERT INTO bbscity VALUES ('533300','怒江傈僳族自治州','530000');
INSERT INTO bbscity VALUES ('533400','迪庆藏族自治州','530000');
INSERT INTO bbscity VALUES ('540100','拉萨市','540000');
INSERT INTO bbscity VALUES ('542100','昌都地区','540000');
INSERT INTO bbscity VALUES ('542200','山南地区','540000');
INSERT INTO bbscity VALUES ('542300','日喀则地区','540000');
INSERT INTO bbscity VALUES ('542400','那曲地区','540000');
INSERT INTO bbscity VALUES ('542500','阿里地区','540000');
INSERT INTO bbscity VALUES ('542600','林芝地区','540000');
INSERT INTO bbscity VALUES ('610100','西安市','610000');
INSERT INTO bbscity VALUES ('610200','铜川市','610000');
INSERT INTO bbscity VALUES ('610300','宝鸡市','610000');
INSERT INTO bbscity VALUES ('610400','咸阳市','610000');
INSERT INTO bbscity VALUES ('610500','渭南市','610000');
INSERT INTO bbscity VALUES ('610600','延安市','610000');
INSERT INTO bbscity VALUES ('610700','汉中市','610000');
INSERT INTO bbscity VALUES ('610800','榆林市','610000');
INSERT INTO bbscity VALUES ('610900','安康市','610000');
INSERT INTO bbscity VALUES ('611000','商洛市','610000');
INSERT INTO bbscity VALUES ('620100','兰州市','620000');
INSERT INTO bbscity VALUES ('620200','嘉峪关市','620000');
INSERT INTO bbscity VALUES ('620300','金昌市','620000');
INSERT INTO bbscity VALUES ('620400','白银市','620000');
INSERT INTO bbscity VALUES ('620500','天水市','620000');
INSERT INTO bbscity VALUES ('620600','武威市','620000');
INSERT INTO bbscity VALUES ('620700','张掖市','620000');
INSERT INTO bbscity VALUES ('620800','平凉市','620000');
INSERT INTO bbscity VALUES ('620900','酒泉市','620000');
INSERT INTO bbscity VALUES ('621000','庆阳市','620000');
INSERT INTO bbscity VALUES ('621100','定西市','620000');
INSERT INTO bbscity VALUES ('621200','陇南市','620000');
INSERT INTO bbscity VALUES ('622900','临夏回族自治州','620000');
INSERT INTO bbscity VALUES ('623000','甘南藏族自治州','620000');
INSERT INTO bbscity VALUES ('630100','西宁市','630000');
INSERT INTO bbscity VALUES ('632100','海东地区','630000');
INSERT INTO bbscity VALUES ('632200','海北藏族自治州','630000');
INSERT INTO bbscity VALUES ('632300','黄南藏族自治州','630000');
INSERT INTO bbscity VALUES ('632500','海南藏族自治州','630000');
INSERT INTO bbscity VALUES ('632600','果洛藏族自治州','630000');
INSERT INTO bbscity VALUES ('632700','玉树藏族自治州','630000');
INSERT INTO bbscity VALUES ('632800','海西蒙古族藏族自治州','630000');
INSERT INTO bbscity VALUES ('640100','银川市','640000');
INSERT INTO bbscity VALUES ('640200','石嘴山市','640000');
INSERT INTO bbscity VALUES ('640300','吴忠市','640000');
INSERT INTO bbscity VALUES ('640400','固原市','640000');
INSERT INTO bbscity VALUES ('640500','中卫市','640000');
INSERT INTO bbscity VALUES ('650100','乌鲁木齐市','650000');
INSERT INTO bbscity VALUES ('650200','克拉玛依市','650000');
INSERT INTO bbscity VALUES ('652100','吐鲁番地区','650000');
INSERT INTO bbscity VALUES ('652200','哈密地区','650000');
INSERT INTO bbscity VALUES ('652300','昌吉回族自治州','650000');
INSERT INTO bbscity VALUES ('652700','博尔塔拉蒙古自治州','650000');
INSERT INTO bbscity VALUES ('652800','巴音郭楞蒙古自治州','650000');
INSERT INTO bbscity VALUES ('652900','阿克苏地区','650000');
INSERT INTO bbscity VALUES ('653000','克孜勒苏柯尔克孜自治州','650000');
INSERT INTO bbscity VALUES ('653100','喀什地区','650000');
INSERT INTO bbscity VALUES ('653200','和田地区','650000');
INSERT INTO bbscity VALUES ('654000','伊犁哈萨克自治州','650000');
INSERT INTO bbscity VALUES ('654200','塔城地区','650000');
INSERT INTO bbscity VALUES ('654300','阿勒泰地区','650000');
INSERT INTO bbscity VALUES ('659000','省直辖行政单位','650000');

/*插入用户*/
insert into bbsuser values ('admin', md5('admin'), '360000', '360900','男', null, now(), now(), '1', '0' );
insert into bbsuser values ('root', md5('root'), '360000', '360900','男', null, now(), now(), '1', '0' );
insert into bbsuser values ('张三', md5('zhangsan'), '360000', '360900','男', null, now(), now(), '0', '0' );
insert into bbsuser values ('李四', md5('lisi'), '360000', '360900','男', null, now(), now(), '0', '0' );
insert into bbsuser values ('王五', md5('wangwu'), '360000', '360900','男', null, now(), now(), '0', '0' );

/*插入板块*/
insert into bbsboard values('1', '技术讨论区', 'admin', now(), now(), '1');
insert into bbsboard values('2', '最新资讯区', 'root', now(), now(), '1');
insert into bbsboard values('3', '自由讨论区', 'admin', now(), now(), '1');

/*插入子版块*/
insert into bbschildboard values('1', 'java语言交流', '1', now(), now(), '1');
insert into bbschildboard values('2', 'c语言交流', '1', now(), now(), '1');
insert into bbschildboard values('3', 'html/web交流', '1', now(), now(), '1');
insert into bbschildboard values('4', 'database交流', '1', now(), now(), '1');
insert into bbschildboard values('5', 'Micosoft最新动态', '2', now(), now(), '1');
insert into bbschildboard values('6', 'Oracle最新动态', '2', now(), now(), '1');
insert into bbschildboard values('7', 'Google最新动态', '2', now(), now(), '1');
insert into bbschildboard values('8', '灌水区', '3', now(), now(), '1');
insert into bbschildboard values('9', '交友区', '3', now(), now(), '1');
insert into bbschildboard values('10', '意见反馈区', '3', now(), now(), '1');

/*插入主贴*/
insert into bbsblog value (null, 'java面向对象编程', 'java面向对象编程的特点', now(), now(), now(), now(), '张三', '1', '0');
insert into bbsblog value (null, 'C语言排序算法', 'C语言的快速排序', now(), now(), now(), now(), 'admin', '2', '0');
insert into bbsblog value (null, 'html中div标签的使用', 'javascript动态修改div标签的内容', now(), now(), now(), now(), 'root', '3', '0');
insert into bbsblog value (null, '数据库回滚操作', 'Mysql数据库中事务的使用', now(), now(), now(), now(), '张三', '4', '0');
insert into bbsblog value (null, '微软发布win10', 'win10的发布动向', now(), now(), now(), now(), '张三', '5', '0');
insert into bbsblog value (null, 'java9新特性', 'java9新特性有哪些？', now(), now(), now(), now(), 'admin', '6', '0');
insert into bbsblog value (null, '安卓5.0相关', '国内手机厂商面对安卓5.x的到来', now(), now(), now(), now(), '李四', '7', '0');
insert into bbsblog value (null, '今天心情真好', '今天心情不错', now(), now(), now(), now(), '张三', '8', '0');
insert into bbsblog value (null, '有西安的朋友吗', '有在西安的朋友吗', now(), now(), now(), now(), '王五', '9', '0');
insert into bbsblog value (null, '论坛Bug反馈', '论坛的一些问题', now(), now(), now(), now(), '李四', '10', '0');

/*跟帖*/
insert into bbsreplyblog value (null, '封装，继承，多态', now(), now(), now(), now(), '李四', '1', '0');
insert into bbsreplyblog value (null, '快速排序的优点', now(), now(), now(), now(), '张三', '2', '0');
insert into bbsreplyblog value (null, 'document.getElementById().InnerHTML()', now(), now(), now(), now(), 'admin', '3', '0');
insert into bbsreplyblog value (null, '银行等大型系统需要用到事务处理', now(), now(), now(), now(), '王五', '4', '0');
insert into bbsreplyblog value (null, '7月29微软发布win10', now(), now(), now(), now(), '李四', '5', '0');
insert into bbsreplyblog value (null, 'java9为java开发带来了更多便利', now(), now(), now(), now(), 'admin', '6', '0');
insert into bbsreplyblog value (null, '安卓5.0支持64位的CPU', now(), now(), now(), now(), 'root', '7', '0');
insert into bbsreplyblog value (null, '今天天气不错', now(), now(), now(), now(), 'admin', '8', '0');
insert into bbsreplyblog value (null, '我现在在西安学习', now(), now(), now(), now(), 'admin', '9', '0');
insert into bbsreplyblog value (null, '论坛访问速度比较慢', now(), now(), now(), now(), 'admin', '10', '0');