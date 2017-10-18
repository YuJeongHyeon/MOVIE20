<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkReg(){
		confirm("등록하시겠습니까?");
	}
</script>

  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">    
  
  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/popper/popper.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>


<div class="card mb-3">
	<div class="card-header">
   		<i class="fa fa-table"></i>영화 등록
   	</div>
	<div class="card-body">
    <div class="table-responsive">
		<form action="DispatcherServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="command" value="movieRegister">
			<table class="table table-bordered" id="dataTable" width="600" cellspacing="20px">
				<tr>
					<th>등록인</th>
					<td colspan="3"><input type="text" value="${requestScope.masterId}" name="id" readonly="readonly"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>상영날짜</th>
					<td colspan="3"><input type="date" name="playdate"></td>
				</tr>
				<tr>
					<th>주인공</th>
					<td><input type="text" name="character"></td>
					<th>감독</th>
					<td><input type="text" name="director"><br>
				</tr>
				<tr>
					<th>장르</th>
					<td colspan="3"><input type="text" name="genre"></td>
				</tr>
				<tr>
					<th>줄거리</th>
					<td colspan="3"><input type="text" name="summary"></td>
				</tr>
				<tr>
					<th>상영시간</th>
					<td><input type="text" name="runtime"></td>
					<th>현재상영여부</th>
					<td><input type="text" name="viewingcheck"></td>
				</tr>
				<tr>
					<th>등급</th>
					<td colspan="3">
						<select name="grade">
							<option value="">--등급--</option>
							<option value="0">전체관람가</option>
							<option value="12">12세 관람가</option>
							<option value="15">15세 관람가</option>
							<option value="19">19세 관람가</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td colspan="3"><input type="file" name="picture"></td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="submit" value="등록" onclick="checkReg()">
					</td>
				</tr>
			</table>
		</form>
	</div>    
	</div>
</div>

<!-- <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Data Table Example</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class=table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Position</th>
                  <th>Office</th>
                  <th>Age</th>
                  <th>Start date</th>
                  <th>Salary</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Name</th>
                  <th>Position</th>
                  <th>Office</th>
                  <th>Age</th>
                  <th>Start date</th>
                  <th>Salary</th>
                </tr>
              </tfoot>
              <tbody>
                <tr>
                  <td>Tiger Nixon</td>
                  <td>System Architect</td>
                  <td>Edinburgh</td>
                  <td>61</td>
                  <td>2011/04/25</td>
                  <td>$320,800</td>
                </tr>
                <tr>
                  <td>Garrett Winters</td>
                  <td>Accountant</td>
                  <td>Tokyo</td>
                  <td>63</td>
                  <td>2011/07/25</td>
                  <td>$170,750</td>
                </tr>
                <tr>
                  <td>Ashton Cox</td>
                  <td>Junior Technical Author</td>
                  <td>San Francisco</td>
                  <td>66</td>
                  <td>2009/01/12</td>
                  <td>$86,000</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
 -->