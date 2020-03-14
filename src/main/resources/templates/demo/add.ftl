<#include "/ftl/layout.ftl">
<@layout>
<!-- TouchSpin -->
<link href="/css/plugins/touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet">
<script src="/js/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script>


<style>
    .form-group label{
        padding-left: 4px;
    }
</style>


<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2 style="margin-left: 10px">新建票券</h2>
    </div>
    <div class="col-lg-2">
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInLeft" style=" padding: 0" >
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox" >
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="addForm">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">票券名称：</label>
                            <div class="col-sm-2"><input type="text" class="form-control required" name="ticketName"></div>
                            <label class="col-sm-2 control-label">金额：</label>
                            <div class="col-sm-2">
                                <input type="text" id="ticketSum" value="" class="form-control required" name="ticketSum">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">订单号：</label>
                            <div class="col-sm-2"><input type="text" class="form-control required" name="admCode"></div>
                            <label class="col-sm-2 control-label">票券说明：</label>
                            <div class="col-sm-4"><input type="text" class="form-control" name="ticketRemarks"></div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">成本中心：</label>
                            <div class="col-sm-2"><input type="text" class="form-control required" name="costCenter"></div>
                            <label class="col-sm-2 control-label">项目编号：</label>
                            <div class="col-sm-2"><input type="text" class="form-control" name="projectCode"></div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label for="s-clerk" class="col-sm-2 control-label">选择管理员：</label>
                            <div class="col-sm-2">
                                <select class="form-control selectpicker required" id="s-clerk" name="clerkName"
                                        data-live-search="true" onchange="selectOnchang(this)"></select>
                            </div>
                            <a href="#" onclick="addClerk()" style="margin-top: 2px" title="新建文员">
                                <i class="fa fa-plus" style="font-size: 1.6em;line-height: 1.7em"></i></a>
                            <input type="hidden" name="clerkId" id="clerkName">
                            <input type="hidden" name="clerkMobile" id="clerkMobile">
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2 text-center">
                                <a class="btn btn-white"  href="#" onclick="back()" >取消</a>
                                <a class="btn btn-primary" href="#" id="saveFormBtn" onclick="saveTicket()">确认</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal inmodal fade" id="modal_confirm" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">创建确认</h4>
            </div>
            <div class="modal-body text-center">
                <pre id="ticketInfo"></pre>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="submitForm()">提交</button>
            </div>
        </div>
    </div>
</div>

<div class="modal inmodal fade" id="modal_add" tabindex="1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog" style="width: 500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">新建管理员</h4>
            ##                <h5 class="font-bold text-warning">交接后所有票券数据将被更新，请谨慎操作</h5>
            </div>
            <div class="modal-body">
                <form id="ch_add_clerk" method="post" class="form-horizontal">
                    <div class="control-group">
                        <label class="col-4 control-label">ITCode：</label>
                        <div class="col-6">
                            <input type="text" class="form-control" required id="add_itcode" name="itcode">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="col-4 control-label">姓&nbsp;&nbsp;&nbsp;名：</label>
                        <div class="col-6">
                            <input type="text" class="form-control"  required id="add_name" name="name">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="clerkChange()">确认</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("#addForm").validate({
            rules: {
                ticketName: {required: true},
                tickeAmount: {required: true,number: true,min:0},
                admCode: {required: true},
                costCenter: {required: true}
            }
        });

        $('#s-clerk').bootstrapSelect({
            url:"/admin/getAllClerk?accesstoken="+$("#_accesstoken").val()+"&authkey="+$("#_authkey").val(),
            valueField: 'userName',
            textField: 'userId',
        });

        $("#ticketSum").TouchSpin({
            min: 0,
            max:".",
            decimals: 2,
            verticalbuttons: true,
            verticalupclass: 'glyphicon glyphicon-chevron-up',
            verticaldownclass: 'glyphicon glyphicon-chevron-down',
        });
    });

    function selectOnchang(obj){
        var value = obj.options[obj.selectedIndex].value;
        var text = obj.options[obj.selectedIndex].text;
        $("#clerkMobile").val(value.split("|")[1]);
        $("#clerkName").val(text);
    }

    function saveTicket(){
        var params = $("#addForm").serializeArray();
        var values = {};
        for(var x in params){
            values[params[x].name] = params[x].value;
        }
        if($('#addForm').valid()){
            $("#ticketInfo").html("<p style='text-left'>名称：" +values.ticketName+"</p>"+
                            "<p>金额：" +values.ticketSum+"</p>"+
                            "<p>订单号：" +values.admCode+"</p>"+
                            "<p>成本中心：" +values.costCenter+"</p>"+
                            "<p>项目编号：" +values.projectCode+"</p>"+
                            "<p>管理员：" +$('#s-clerk option:selected').text()+"</p>"+
                            "<p>说明：" +values.ticketRemarks+"</p>"

        );
            $("#modal_confirm").modal('show');
        }
    }

    function submitForm(){
        if ($("#addForm").valid()) {//获取验证结果，如果成功，执行下面代码
            var data=$('#addForm').serialize();
            var submitData=decodeURIComponent(data,true);
            $.ajax({
                url:'/admin/ticketSave?accesstoken='+$("#_accesstoken").val()+"&authkey="+$("#_authkey").val(),
                data:submitData,
                type:"POST",
                cache:false,//false是不缓存，true为缓存
                async:false,//true为异步，false为同步
                success:function(result){
//                    console.log(result)
                    if(result.code=="1000"){
                        $("#modal_confirm").modal('hide');
                        swal("成功", "创建成功！", "success");
                        window.location.href="/admin/ticketAdminPage?accesstoken="+$("#_accesstoken").val()+"&authkey="+$("#_authkey").val();
                    }else{
                        swal("失败", "创建失败！ 错误："+result.msg, "error");
                    }
                },
                error:function(){
                    swal("错误", "请求失败,请稍候再试。", "error");
                }
            })

        }
    }

    function back(){
        window.location.href="/page";
    }

    function clerkChange(){
        if ($("#ch_add_clerk").valid()) {//获取验证结果，如果成功，执行下面代码
            var data = $('#ch_add_clerk').serialize();
            var submitData = decodeURIComponent(data, true);
            $.ajax({
                url: '/admin/addClerk?accesstoken=' + $("#_accesstoken").val() + "&authkey=" + $("#_authkey").val(),
                data: submitData,
                type: "POST",
                cache: false,//false是不缓存，true为缓存
                async: false,//true为异步，false为同步
                success: function (result) {
//                    console.log(result)
                    if (result.code == "1000") {
                        $('#modal_add').modal('hide');
                        swal("成功", "操作成功！", "success");
                        $('#s-clerk').bootstrapSelect({
                            url:"/admin/getAllClerk?accesstoken="+$("#_accesstoken").val()+"&authkey="+$("#_authkey").val(),
                            valueField: 'userId',
                            textField: 'userName',
                        });
                    } else {
                        swal("失败", "操作失败！ 错误：" + result.msg, "error");
                    }
                },
                error: function () {
                    swal("错误", "请求失败,请稍候再试。", "error");
                }
            })
        }
    }

    function addClerk() {
        $("input[id^='add_']").val("");
        $('#modal_add').modal();
    }

</script>
</@layout>