import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo";
import {FormControl} from "@angular/forms";
import {TodoService} from "../todo.service";

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todos: Todo[] = [];

  content = new FormControl();
  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.todoService.getTodos().subscribe(next => {
      this.todos = next;
    })
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
    const todo = this.todos[i];
    const todoData = {
      ...todo,
      completed: !todo.complete
    };
    this.todoService.updateTodo(todoData).subscribe(next => {
      this.todos[i].complete = next.complete;
    });
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  addTodo() {
    const todo: Partial<Todo> = {
      title: this.content.value,
      completed: false,
    };
    this.todoService.createTodo(todo).subscribe(next => {
      this.todos.unshift(next);
      this.content.setValue('');
    });
  }

  deleteTodo(i) {
    const todo = this.todos[i];
    this.todoService.deleteTodo(todo.id).subscribe(() => {
      this.todos = this.todos.filter(t => t.id !== todo.id);
    });
  }
}
