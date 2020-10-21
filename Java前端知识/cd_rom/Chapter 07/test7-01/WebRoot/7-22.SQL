--定义了一个存储过程:求面积
create or replace procedure get_area_sub
	(vlength in number,vwidth in number,varea out number)
	----传入长，宽求面积。
as
begin
	varea :=vlength *vwidth;
end;
/
