set serveroutput on
create or replace 
procedure Hello is
    begin
      dbms_output.put_line('Hello World');
    end;
/
--调用一个存储过程
call Hello();
