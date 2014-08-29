<?php

  
?>

<?php
  include "../templates/header.php";
?>

<form action="processlogin.php" method="post">
  Username <input type="text" name="var_username" value="" /> <br />
  Password <input type="password" name="var_password" value=""/> <br />
  <input type="submit" value="Login" /> <br />
</form>

<?php
  include "./templates/footer.php";
?>
