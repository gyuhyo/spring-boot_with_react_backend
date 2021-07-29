package com.todolist.exam.mapper;

import com.todolist.exam.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("select * from todo")
    public List<Todo> read();

    @Select("select * from todo where id = #{id}")
    public Todo readById(long id);

    @Insert("insert into todo (id, todoName, completed) values (seq_todo.nextval, #{todoName}, #{completed})")
    public void create(Todo todo);

    @Update("update todo set completed = #{completed} where id = #{id}")
    public void update(Todo todo);

    @Delete("delete from todo where id = #{id}")
    public void delete(long id);
}
