package com.example.todolistdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.todolistdatabase.db.Todo
import com.example.todolistdatabase.db.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTodo.requestFocus()

        val todoAdapter = ArrayAdapter<Todo>(
            this, android.R.layout.simple_list_item_1,
            android.R.id.text1, todos
        )

        val db = MyDbHelper(this).writableDatabase

        fun refreshTodoList(){
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
//            Log.d("Todos", todoList.toString())
        }

        ListTodo.adapter = todoAdapter

        refreshTodoList()

        btnAdd.setOnClickListener{
            val newToDo = Todo(etTodo.text.toString(), false)
            TodoTable.insertTodo(db,newToDo)
            refreshTodoList()
        }

    }
}

