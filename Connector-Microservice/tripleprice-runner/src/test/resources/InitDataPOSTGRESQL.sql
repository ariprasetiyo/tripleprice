
--drop table sys_user_roles;
--drop table sys_user;
--drop table sys_authorization;
--drop table  sys_menu;
--drop table  sys_roles;
--drop table  sys_audit_trail;

--delete from sys_user_roles;
--delete from sys_user;
--delete from  sys_menu;
--delete from  sys_roles;

INSERT INTO sys_menu (id, created_by, created_time, disabled, modified_by, modified_time, version, menus_name, url) VALUES
(1, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Dashboard', NULL),
(2, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Dashboard V1', '/Dashboard/V1'),
(3, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Dashboard V2', '/Dashboard/V2'),
(4, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Utility', NULL),
(5, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Setting User', NULL),
(6, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-11-26 05:35:26', '1.0', 'User', '../../../admin/v1/view/main#/user/'),
(7, NULL, '2017-02-07 10:00:00', true, NULL, '2018-01-28 12:54:53', '1.0', 'Authorization', '../../../admin/v1/view/main#/authorization/'),
(8, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Profile Setting', 'admin/v1/setting/calendar'),
(9, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Report Setting', 'admin/v1/reportsetting '),
(10, 'ari', '2017-02-07 10:00:00', false, 'ari', '2017-02-07 10:00:00', '1.0', 'Calendar Setting', 'admin/v1/setting/calendar'),
(11, NULL , '2017-04-18 10:00:00', false, NULL, '2017-04-18 10:00:00', '1.0', 'Application Setting', NULL),
(12, NULL, '2017-04-18 10:00:00', false, NULL, '2018-01-28 13:33:27', '1.0', 'Add Menu', '../../../admin/v1/view/menu'),
(13, NULL, '2017-04-18 10:00:00', false, NULL, '2018-01-20 05:45:58', '1.0', 'User Group', '../../../admin/v1/view/main#/usergroup/'),
(14, NULL, '2017-04-18 10:00:00', true, NULL, '2018-01-28 12:39:26', '1.0', 'Basic Web', '../../../admin/v1/view/basicweb'),
(15, NULL, '2017-11-03 22:07:08', true, NULL, '2018-01-28 12:54:48', '1.0', 'basic SPA', '../../../admin/v1/view/main#/sample-spa/');

INSERT INTO sys_roles (id, created_by, created_time, disabled, modified_by, modified_time, version, role_name) VALUES
(1, NULL, '2016-11-19 18:38:52', false, NULL, '2016-11-19 18:38:52', '1.0', 'admin'),
(2, NULL, '2016-11-19 18:38:52', false, NULL, '2016-11-19 18:38:52', '1.0', 'approval'),
(3, NULL, '2016-11-19 18:38:52', true, NULL, '2018-01-28 12:52:46', '1.0', 'user'),
(4, NULL, '2016-11-19 18:38:52', true, NULL, '2018-01-21 15:13:49', '1.0', 'public'),
(5, NULL, '2018-01-21 14:27:35', false, NULL, '2018-01-28 12:50:13', '1.0', 'test'),
(6, NULL, '2018-01-28 12:53:13', true, NULL, '2018-01-28 12:53:13', '1.0', 'test1'),
(7, NULL, '2018-01-28 12:53:20', false, NULL, '2018-01-28 12:53:20', '1.0', 'test2');

INSERT INTO sys_authorization (id, created_by, created_time, disabled, modified_by, modified_time, version, is_delete, is_insert, is_read, is_update, parent_id, sys_menu_id, sys_roles_id) VALUES
(69, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-28 13:11:41', '1.0', false, true, true, true, NULL, 1, 1),
(70, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-28 12:45:46', '1.0', false, true, true, false, 69, 2, 1),
(71, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-28 12:56:10', '1.0', true, true, true, true, 69, 3, 1),
(72, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-21 15:28:39', '1.0', false, true, true, true, NULL, 4, 1),
(73, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-21 15:28:28', '1.0', false, true, true, false, 72, 5, 1),
(74, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-21 15:28:32', '1.0', false, true, true, true, 73, 6, 1),
(75, NULL, '2016-12-11 15:01:14', true, NULL, '2018-01-21 15:28:34', '1.0', true, true, true, true, 73, 7, 1),
(76, NULL, '2016-12-11 15:01:14', true, NULL, '2016-12-11 15:01:14', '1.0', true, true, true, true, 72, 8, 1),
(77, NULL, '2016-12-11 15:01:15', true, NULL, '2016-12-11 15:01:15', '1.0', false, true, true, true, 72, 9, 1),
(78, NULL, '2016-12-11 15:01:15', true, NULL, '2018-01-21 14:26:15', '1.0', true, true, true, true, 72, 10, 1),
(132, NULL, '2017-02-12 10:16:01', false, NULL, '2018-01-28 13:16:45', '1.0', false, false, true, false, NULL, 1, 2),
(139, NULL, '2017-02-12 15:09:17', true, NULL, '2017-02-12 15:09:17', '1.0', true, true, true, true, NULL, 1, 2),
(140, NULL, '2017-02-13 15:05:11', true, NULL, '2017-02-13 15:05:11', '1.0', true, true, true, true, 132, 1, 2),
(142, NULL, '2017-02-15 02:56:44', true, NULL, '2017-02-15 02:56:44', '1.0', true, true, true, true, NULL, 1, 2),
(143, NULL, '2017-02-15 02:59:49', false, NULL, '2017-02-15 02:59:49', '1.0', true, true, true, true, NULL, 1, 2),
(155, NULL, '2017-02-15 04:24:54', false, NULL, '2017-02-15 04:24:54', '1.0', false, false, true, false, 132, 2, 2),
(157, NULL, '2017-02-15 04:55:37', true, NULL, '2017-02-15 04:55:37', '1.0', true, true, true, true, NULL, 1, 2),
(163, NULL, '2017-02-15 11:36:54', true, NULL, '2017-02-15 11:36:54', '1.0', true, true, true, true, NULL, 1, 2),
(165, NULL, '2017-02-15 11:55:11', true, NULL, '2017-02-15 11:55:11', '1.0', true, true, true, true, NULL, 2, 2),
(181, NULL, '2017-02-15 13:01:36', true, NULL, '2017-02-15 13:01:36', '1.0', true, true, true, true, 132, 1, 2),
(183, NULL, '2017-02-15 15:07:43', true, NULL, '2017-02-15 15:07:43', '1.0', true, true, true, true, NULL, 2, 2),
(189, NULL, '2017-02-15 15:19:18', true, NULL, '2017-02-15 15:19:18', '1.0', true, true, true, true, NULL, 2, 2),
(197, NULL, '2017-02-16 15:40:37', false, NULL, '2018-01-21 14:20:15', '1.0', true, true, true, true, NULL, 1, 2),
(240, NULL, '2017-04-19 08:52:41', true, NULL, '2017-04-19 08:52:41', '1.0', true, true, true, true, 73, 13, 1),
(243, NULL, '2017-04-19 08:56:24', true, NULL, '2017-04-19 08:56:24', '1.0', true, true, true, true, 72, 11, 1),
(244, NULL, '2017-04-19 08:57:01', true, NULL, '2017-04-19 08:57:01', '1.0', true, true, true, true, 243, 12, 1),
(246, NULL, '2017-04-19 11:32:40', true, NULL, '2017-04-19 11:32:40', '1.0', true, true, true, true, NULL, 15, 1),
(260, NULL, '2017-04-19 11:32:40', true, NULL, '2017-04-19 11:32:40', '1.0', true, true, true, true, NULL, 14, 1);

INSERT INTO sys_user (id, created_by, created_time, disabled, modified_by, modified_time, version, email, is_active, name, no_hp, password, username) VALUES
(1, NULL, '2017-04-16 01:14:39', false, NULL, '2017-12-09 11:15:58', NULL, 'prasetiyooo@gmail.com', true, 'notblank', '085645480401', 'dummay', 'ari'),
(3, NULL, '2017-12-09 13:26:42', false, NULL, '2018-01-21 14:44:14', NULL, 'aria@adasd.com', true, 'aria p', '12345667889', '123456789', 'aria'),
(5, NULL, '2017-12-16 03:41:58', false, NULL, '2017-12-16 03:42:11', NULL, 'aritest@gmail.com', false, 'aritest', '1234556788', 'aritest1', 'AriTest');

INSERT INTO sys_user_roles (id, created_by, created_time, disabled, modified_by, modified_time, version, sys_roles_id, sys_user_id) VALUES
(6, NULL, '2017-12-09 11:15:58', false, NULL, '2017-12-09 11:15:58', NULL, 1, 1),
(38, NULL, '2017-12-16 03:42:11', false, NULL, '2017-12-16 03:42:11', NULL, 3, 5),
(42, NULL, '2018-01-21 14:44:14', false, NULL, '2018-01-21 14:44:14', NULL, 2, 3);

