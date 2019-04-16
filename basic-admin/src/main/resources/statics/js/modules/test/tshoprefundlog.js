$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/tshoprefundlog/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '退款编号', name: 'sn', index: 'sn', width: 80 }, 			
			{ label: '会员账号', name: 'account', index: 'account', width: 80 }, 			
			{ label: '外部订单id', name: 'outOrderId', index: 'out_order_id', width: 80 }, 			
			{ label: '退款金额，单位分', name: 'refundAmount', index: 'refund_amount', width: 80 }, 			
			{ label: '第三方退款流水号', name: 'tradeNo', index: 'trade_no', width: 80 }, 			
			{ label: '退款方式(支付宝：alipay，微信:wechat)', name: 'refundType', index: 'refund_type', width: 80 }, 			
			{ label: '退款状态（wait 等待退款 success 退款成功 failed 退款失败 canceled 退款取消 closed 退款关闭）', name: 'refundStatus', index: 'refund_status', width: 80 }, 			
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '创建时间', name: 'createDate', index: 'create_date', width: 80 }, 			
			{ label: '修改人', name: 'modifyBy', index: 'modify_by', width: 80 }, 			
			{ label: '修改时间', name: 'modifyDate', index: 'modify_date', width: 80 }, 			
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
		tShopRefundLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tShopRefundLog = {};
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
			var url = vm.tShopRefundLog.id == null ? "sys/tshoprefundlog/save" : "sys/tshoprefundlog/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tShopRefundLog),
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
				    url: baseURL + "sys/tshoprefundlog/delete",
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
			$.get(baseURL + "sys/tshoprefundlog/info/"+id, function(r){
                vm.tShopRefundLog = r.tShopRefundLog;
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