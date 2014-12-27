<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<script type="text/javascript" >
	$(document).ready(function() {
		$("#J-thrNav-menu").hide();
		$("#J-thrNav-menu").find(".subList").addClass("f-dn");
		$("#J-thrNav-menu").mouseleave(function(){
			$("#J-thrNav-menu").hide();
			$("#J-thrNav-menu").find(".subList").addClass("f-dn");
		});
	});
	function showMenu(parentID){
		$("#J-thrNav-menu").find(".subList").addClass("f-dn");
		$("#subList_"+parentID).removeClass("f-dn");
		$("#J-thrNav-menu").show();
	}
</script>
		<div class="m-subList"  id="J-thrNav-menu" style="display:none;">
			<ul id="subList_1" class="subList f-dn">
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=1" target="main">计划财务中心指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=2" target="main">产品精算部指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=3" target="main">战略企划部指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=4" target="main">资产管理中心指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=5" target="main">风控合规部指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=6" target="main">运营管理部指标数据录入</a></li>
				<li><a href="${ctx}riskInstance/queryForInsert.do?deptNo=7" target="main">综合管理部指标数据录入</a></li>
			</ul>
			<ul id="subList_2" class="subList f-dn">
				<li><a href="${ctx}report/querySummary.do" target="main">指标综合查询</a></li>
				<li><a href="${ctx}report/queryDetail.do" target="main">指标明细查询</a></li>
				<li><a href="${ctx}report/queryOciSummary.do" target="main">监管指标查询</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=1" target="main">仪表盘总览</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=2" target="main">仪表盘年度</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=3" target="main">仪表盘半年度</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=4" target="main">仪表盘季度</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=5" target="main">仪表盘月度</a></li>
				<li><a href="${ctx}report/queryCognosReport.do?queryFlag=10" target="main">监测明细表</a></li>
			</ul>
			<ul id="subList_3" class="subList f-dn">
				<li><a href="${ctx}riskDeclare/queryForInit.do" target="main">指标管理</a></li>
			</ul>
			<ul id="subList_4" class="subList f-dn">
				<li><a href="${ctx}systemManage/queryDept.do" target="main">组织架构查询</a></li>
				<li><a href="${ctx}systemManage/queryRole.do" target="main">角色管理</a></li>
				<li><a href="${ctx}systemManage/queryUser.do" target="main">用户管理</a></li>
				<li><a href="${ctx}systemManage/queryOprLog.do" target="main">操作日志</a></li>
				<li><a href="${ctx}systemManage/querySchedule.do" target="main">调度管理</a></li>
				<li><a href="${ctx}systemManage/queryNotePress.do" target="main">自动提醒</a></li>
				<!--li><a href="${ctx}systemManage/updateRiskFactorInstance.do" target="main">指标数据补录/修正</a></li-->
				<li><a href="${ctx}systemManage/queryReCal.do" target="main">数据重新计算</a></li>
				<li><a href="${ctx}systemManage/workingDay.do" target="main">工作日管理</a></li>
				<li><a href="${ctx}systemManage/queryInstanceStatistics.do" target="main">数据录入情况</a></li>
			</ul>
			<ul id="subList_5" class="subList f-dn">
				<li><a href="javascript:viod(0);" target="main">整改方案</a></li>
				<li><a href="javascript:viod(0);" target="main">问题追踪</a></li>
			</ul>
		</div>