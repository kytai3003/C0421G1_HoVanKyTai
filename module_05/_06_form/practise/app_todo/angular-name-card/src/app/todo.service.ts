import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "./todo";

const API_URL = "http://localhost:3000/todo";
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todoList: Todo[];

  constructor(private httpClient: HttpClient) { }

  getAll() : Observable<Todo[]> {
      return this.httpClient.get<Todo[]>(API_URL);
  }
}
