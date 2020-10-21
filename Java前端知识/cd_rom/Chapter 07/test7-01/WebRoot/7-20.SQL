set serveroutput on
declare
  procedure Hello is
    begin
      dbms_output.put_line('Hello World');
    end;
begin
  hello ();
end;
/
