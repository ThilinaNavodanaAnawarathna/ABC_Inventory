<%@include file="/WEB-INF/jspf/header.jspf" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Add Floor</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item">Home</li>
                        <li class="breadcrumb-item active">Add Customer</li>
                    </ol>
                </div>
            </div>


            <span id="msg"></span>

        </div><!-- /.container-fluid -->
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card card-secondary">
                        <form id="form">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Name:</label>

                                    <input type="text" class="form-control" id="name" name="name" placeholder="Name" autofocus>
                                </div>

                                <div class="form-group">
                                    <label>Address:</label>

                                    <input type="text" class="form-control" id="address" name="address" placeholder="Address">
                                </div>

                                <div class="form-group">
                                    <label>Email:</label>

                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                                </div>

                                <div class="form-group">
                                    <label>Telephone Number:</label>

                                    <input type="number" class="form-control" id="telephone" name="telephone" placeholder="Telephone Number">
                                </div>
                            </div>

                            <div class="card-footer">
                                <button type="submit" id="saveBtn" class="btn btn-primary">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<%@include file="/WEB-INF/jspf/footer.jspf" %>

<script>
    $(function () {
        $("#administration-menu").css('display', 'block');
        $(".customer").removeClass("treeview").addClass("treeview menu-open");
        $("#add_customer").addClass("active");

        $('#form').validate({
            rules: {
                name: {
                    required: true
                },
                address: {
                    required: true
                },
                email: {
                    required: true
                },
                telephone: {
                    required: true
                }
            },
            submitHandler: function (form,event) {
                event.preventDefault();

                var form = $('form')[0]; // You need to use standard javascript object here
                var formData = new FormData(form);

                $.ajax({
                    type: "POST",
                    url: "/customer/add_customer",
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (result) {
                        if (result == "200") {
                            $("#form")[0].reset();
                            $('#msg').append('<div class="alert alert-success alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Customer added successfully</h4></div>');
                        } else {
                            $('#msg').append('<div class="alert alert-danger alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Customer added failed</h4></div>');
                        }
                    },
                    error: function (result) {
                        $('#msg').append('<div class="alert alert-danger alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Customer added failed</h4></div>');
                    }
                });
            }
        });
    });
</script>
</body>
</html>
