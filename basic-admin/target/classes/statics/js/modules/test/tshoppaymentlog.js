$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/tshoppaymentlog/list',
        datatype: "json",
        colModel: [			
			//{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '支付编号', name: 'sn', index: 'sn', width: 80 }, 			
			{ label: '会员账号', name: 'account', index: 'account', width: 80 }, 			
			{ label: '外部订单id', name: 'outOrderId', index: 'out_order_id', width: 80 }, 			
			{ label: '支付金额，单位分', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: 'U币数量，单位个', name: 'ubCount', index: 'ub_count', width: 80 }, 			
			{ label: '第三方支付流水号', name: 'tradeNo', index: 'trade_no', width: 80 }, 			
			{ label: '支付方式(支付宝：alipay，微信:wechat)', name: 'paymentType', index: 'payment_type', width: 80 }, 			
			{ label: '支付状态（wait 等待付款 success 支付成功 failed 支付失败 canceled 支付取消 closed 支付关闭）', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 }, 			
		//	{ label: '创建时间', name: 'createDate', index: 'create_date', width: 80 }, 			
		//	{ label: '修改人', name: 'modifyBy', index: 'modify_by', width: 80 }, 			
		//	{ label: '修改时间', name: 'modifyDate', index: 'modify_date', width: 80 }, 			
			{ label: '版本', name: 'version', index: 'version', width: 80 }, 			
			{ label: '是否已删除,0:未删除；1:已删除', name: 'isDeleted', index: 'is_deleted', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		tShopPaymentLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tShopPaymentLog = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.tShopPaymentLog.id == null ? "sys/tshoppaymentlog/save" : "sys/tshoppaymentlog/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tShopPaymentLog),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/tshoppaymentlog/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/tshoppaymentlog/info/"+id, function(r){
                vm.tShopPaymentLog = r.tShopPaymentLog;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});