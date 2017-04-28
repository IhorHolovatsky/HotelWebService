INSERT INTO security_role(RoleID, RoleName)
VALUES ('1542c35d-346a-4a88-9a2e-cfda649b40d9','Admin'), ('0a4dca96-4aa2-4d67-9350-8b6287e512f7','Customer')

INSERT INTO security_user (UserID, Login, Password)
VALUES ('c8b1f66f-dc7d-4b73-aa04-07eba5f679e3', 'admin', '1'), ('f7b16bbb-aef9-4c25-93f5-a36bb24dbfa3', 'customer', '1')

INSERT INTO security_userInRole(UserID, RoleID)
VALUES ('c8b1f66f-dc7d-4b73-aa04-07eba5f679e3', '1542c35d-346a-4a88-9a2e-cfda649b40d9'), ('f7b16bbb-aef9-4c25-93f5-a36bb24dbfa3', '0a4dca96-4aa2-4d67-9350-8b6287e512f7')
