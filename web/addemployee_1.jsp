<link href="css/signin.css" rel="stylesheet">
<main class="form-signin">
    
  <form action="AddEmployee" method="Post">
    
    <h1 class="h4 mb-3 fw-normal" center>Add Employee Data</h1>

<!--    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Employee ID" name="employeeId" value= readonly>
      <label for="floatingInput">Employee ID</label>
    </div>    -->
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="First Name" name="firstName" required maxlength="45">
      <label for="floatingInput">First Name<span class="required">*</span></label>
    </div>
    
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Last Name" name="lastName" required maxlength="45">
      <label for="floatingInput">Last Name<span class="required">*</span></label>
    </div>
    
    <div class="form-floating">
      <input type="tel" class="form-control" id="floatingInput" placeholder="Phone Number" name="phone" required maxlength="13" pattern="[0-9]{3}[0-9]{3}[0-9]{4}">
      <label for="floatingInput">Phone Number<span class="required">*</span></label>
    </div>
    
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Address" name="address" required maxlength="45">
      <label for="floatingInput">Address<span class="required">*</span></label>
    </div>
        
<!--    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" required maxlength="10">
      <label for="floatingInput">Gender</label>
    </div>-->
    

    
    <div class="form-floating">
        <input type="number" class="form-control" id="floatingInput" placeholder="age" name="age" min="15" max="100" required>
      <label for="floatingInput">Age<span class="required">*</span></label>
    </div>
        
    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="basic salary" name="basicSalary" required>
      <label for="floatingInput">Basic Salary<span class="required">*</span></label>
    </div>
    
    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Car Allowance" name="carAllowance" required>
      <label for="floatingInput">Car Allowance<span class="required">*</span></label>
    </div>
       
    <div class="form-floating">

    <select id="gender" name="gender" class="form-select" required>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select>
    <label for="floatingInput">Gender<span class="required">*</span></label>
    </div>
 
      <div class="form-floating">
          
          <select name="departmentId" class="form-select" id="departmentId">
                       <option value="" selected="selected">Select Department </option>
                   <option value="1">Ops</option>
                   <option value="2">Java</option>
                   <option value="3">Accounts</option>
                   <option value="4">MuleSoft</option>
                   <option value="5">Fullstack</option>
                   </select> 
              
          </select>
          <label for="floatingInput">Department<span class="required">*</span></label>
      </div>
          
      <div class="form-floating">
         
         <select name="roleId" class="form-select" id="roleId">
                        <option value="" selected="selected">Select Role </option>
                   <option value="1">Manager</option>
                   <option value="2">HR Manager</option>
                   <option value="3">Employee</option>
                   </select>
      </div>&nbsp;
     
    <button class="w-100 btn btn-lg btn-primary" style="background-color: blue; border: none" type="submit">Save</button>
    
  </form>
</main>
