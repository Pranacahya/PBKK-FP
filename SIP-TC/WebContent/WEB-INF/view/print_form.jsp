<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Register</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value="/resources/sb_admin/vendor/fontawesome-free/css/all.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" />"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="<c:url value="/resources/sb_admin/css/sb-admin-2.min.css" />"
	rel="stylesheet">
<style>
.hide {
	display: none;
}
</style>
</head>

<body class="bg-gradient-primary ">

	<div class="container d-flex justify-content-center">

		<div class="card o-hidden border-0 my-5 col-lg-8 ">
			<div class="card-body p-1">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
					<div class="col-lg">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4 font-weight-bold ">SIPTC</h1>
							</div>
							<form  modelAttribute="Transaksi" method="POST" enctype="multipart/form-data" action="prosesUser">
								<div class="form-group">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="printName" placeholder="Name" name="nama_user">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="printNRP" placeholder="NRP" name="nrp_user">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" name="file_user" class="custom-file-input"
												id="inputGroupFile01"
												aria-describedby="inputGroupFileAddon01"> <label
												class="custom-file-label" for="inputGroupFile01">Choose
												file</label>
										</div>
									</div>
								</div>
								<div class="form-group pl-2 row">
									<div class="col-sm-4 ">
										<label class="font-weight-bold" for="">Number of
											Copies</label> <input type="number" name="copies_user" class="form-control form-control"
											id="numberCopy" placeholder="1">
									</div>
									<div class="col-sm-3">
										<label class="font-weight-bold" for="">Pages</label>
										<div class="custom-control custom-radio">
											<input type="radio" class="custom-control-input"
												id="defaultChecked" name="pages_user" checked onclick="show1()">
											<label class="custom-control-label" for="defaultChecked">All
												Pages</label>
										</div>
										<div class="custom-control custom-radio">
											<input type="radio" class="custom-control-input"
												id="defaultUnchecked" name="pages_user" onclick="show2()">
											<label class="custom-control-label" for="defaultUnchecked">Pages</label>
										</div>

									</div>
									<div class="col-sm-3 hide" id="detailPage">
										<label class="font-weight-bold" for="">Pages detail</label> 
										<input
											type="text" class="form-control form-control-user" name="pages_user"
											id="numberCopy" placeholder="1"> <small
											class="form-text text-muted">ex: 2-5 or 2,4,6</small>
									</div>
								</div>
								<div class="form-group pl-2 row">
									<div class="col-sm-3">
										<label class="font-weight-bold" for="">Color</label>
										<div class="input-group">
											<select class="custom-select" name="color_user" id="">
												<option value="">Choose</option>
												<option value="fullColor">Full Color</option>
												<option value="grayscale">Grayscale</option>
											</select>
										</div>

									</div>
									<div class="col-sm-4">
										<Label class="font-weight-bold">Paper Size</Label>
										<div class="input-group">
											<select class="custom-select" name="paper_user" id="">
												<option value="">Choose</option>
												<option value="A4">A4</option>
												<option value="A5">A5</option>
												<option value="Letter">Letter</option>
											</select>
										</div>
									</div>
									<div class="col-sm-4">
										<Label class="font-weight-bold">Side</Label>
										<div class="input-group">
											<select class="custom-select" name="side_user" id="">
												<option value="">Choose</option>
												<option value="oneSide">One Side</option>
												<option value="twoSides">Two Sides</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<Label class="font-weight-bold">Note</Label>
									<div class="input-group">
										<textarea name="note_user" class="form-control" aria-label="With textarea"></textarea>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" value="SUBMIT">
								</div>
								<hr>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script
		src="<c:url value="/resources/sb_admin/vendor/jquery/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/sb_admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="/resources/sb_admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/resources/sb_admin/js/sb-admin-2.min.js"/>"></script>
	<script>
    $('#inputGroupFile01').on('change',function(){
        //get the file name
        var fileName = $(this).val();
        //replace the "Choose a file" label
        $(this).next('.custom-file-label').html(fileName);
    })
</script>
	<script>
    function show1(){
      document.getElementById('detailPage').style.display ='none';
    }
    function show2(){
      document.getElementById('detailPage').style.display = 'block';
    }
  </script>

</body>

</html>
