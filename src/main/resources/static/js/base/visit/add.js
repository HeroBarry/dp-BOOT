/**
 * 新增-来访登记js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		visit: {
			id: 0
		},
        org: {
            parentId: 0,
            parentName: null,
            orderNum: 0,
            status: 1,
            layer: 1
        }
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../visit/visit/save?_' + $.now(),
		    	param: vm.visit,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
