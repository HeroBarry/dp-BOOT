/**
 * 编辑-来访登记js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		visit: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../visit/visit/info?_' + $.now(),
		    	param: vm.visit.id,
		    	success: function(data) {
		    		vm.visit = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../visit/visit/update?_' + $.now(),
		    	param: vm.visit,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})