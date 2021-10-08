import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "./todo";
import {map} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class TodoService {
  API_URL = "http://localhost:3000/todo";
  todoList: Todo[];

  constructor(private httpClient: HttpClient) { }

  getTodos(count = 5): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.API_URL).pipe(
      map(response => response.filter((todo, i) => i < count))
    );
  }

  getTodoById(id: number): Observable<Todo> {
    return this.httpClient.get<Todo>(`${this.API_URL}/${id}`);
  }
  createTodo(todo: Partial<Todo>): Observable<Todo> {
    return this.httpClient.post<Todo>(this.API_URL, todo);
  }
  deleteTodo(id: number): Observable<any> {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }
  updateTodo(todo: Todo): Observable<Todo> {
    return this.httpClient.put<Todo>(`${this.API_URL}/${todo.id}`, todo);
  }
}
