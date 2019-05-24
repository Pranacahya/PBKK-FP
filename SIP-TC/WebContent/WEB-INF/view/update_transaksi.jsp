<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIPTC</title>
</head>
<body>
	<form:form modelAttribute="transaksi" action="updatetransaksi" method="POST">
		<form:hidden path="id"/>
		<form:label path="nama_user">Nama Pemesan </form:label>
		<form:input path="nama_user" readonly="true"/>
		<form:label path="nrp_user">NRP Pemesan </form:label>
		<form:input path="nrp_user" readonly="true"/>
		<form:label path="tanggal_transaksi">Tanggal Transaksi </form:label>
		<form:input path="tanggal_transaksi" readonly="true"/>
		<form:label path="waktu_transaksi">Waktu Transaksi </form:label>
		<form:input path="waktu_transaksi" readonly="true"/>
		<form:label path="file_user">Path File </form:label>
		<form:input path="file_user" readonly="true"/>
		<form:label path="note_user">Catatan </form:label>
		<form:textarea path="note_user" readonly="true"/>
		<form:select path="status">
			<c:forEach var="oneStatus" items="${statuses}">
				<form:option value="${oneStatus}" label="${oneStatus.nama_status}"></form:option>
			</c:forEach>
		</form:select>
		<form:label path="total_harga">Harga </form:label>
		<form:input path="total_harga"/>
		
		<input type="submit" value="Update Data"/>
	</form:form>
</body>
</html>