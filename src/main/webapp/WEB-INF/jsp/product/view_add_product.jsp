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
                        <li class="breadcrumb-item active">Add Product</li>
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
                                    <label>Price:</label>

                                    <input type="number" class="form-control" id="price" name="price" placeholder="Price">
                                </div>

                                <div class="form-group">
                                    <label>Expired Date:</label>

                                    <div class="input-group date" id="expirdDatedDiv" data-target-input="nearest">
                                        <input type="text" class="form-control datetimepicker-input"
                                               id="expirdDate"
                                               name="expirdDate" data-target="#expirdDatedDiv"
                                               placeholder="dd/mm/yyyy"/>

                                        <div class="input-group-append" data-target="#expirdDatedDiv"
                                             data-toggle="datetimepicker">
                                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                        </div>
                                    </div>

                                </div>

                                <div class="form-group">
                                    <label>Tax Rate (%):</label>

                                    <input max="100" min="0"  type="number" class="form-control" id="taxRate" name="taxRate" placeholder="Tax Rate (%)">
                                </div>

                                <div class="form-group">
                                    <label>Discount Rate (%):</label>

                                    <input max="100" min="0" type="number" class="form-control" id="discountRate" name="discountRate" placeholder="Discount Rate (%)">
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
        $(".product").removeClass("treeview").addClass("treeview menu-open");
        $("#add_product").addClass("active");

        $('#expirdDatedDiv').datetimepicker({
            format: 'DD/MM/YYYY'
        });

        $('#form').validate({
            rules: {
                name: {
                    required: true
                },
                price: {
                    required: true
                },
                expirdDate: {
                    required: true
                },
                taxRate: {
                    required: true
                },
                discountRate: {
                    required: true
                }
            },
            submitHandler: function (form,event) {
                event.preventDefault();

                var form = $('form')[0]; // You need to use standard javascript object here
                var formData = new FormData(form);

                $.ajax({
                    type: "POST",
                    url: "/product/add_product",
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (result) {
                        if (result == "200") {
                            $("#form")[0].reset();
                            $('#msg').append('<div class="alert alert-success alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Product added successfully</h4></div>');
                        } else {
                            $('#msg').append('<div class="alert alert-danger alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Product added failed</h4></div>');
                        }
                    },
                    error: function (result) {
                        $('#msg').append('<div class="alert alert-danger alert-dismissible"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button><h4><i class="icon fa fa-check"></i>Product added failed</h4></div>');
                    }
                });
            }
        });
    });
</script>
</body>
</html>
