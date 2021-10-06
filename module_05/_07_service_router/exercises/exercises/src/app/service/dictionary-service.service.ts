import { Injectable } from '@angular/core';
import {IWord} from "../model/IWord";

@Injectable({
  providedIn: 'root'
})

export class DictionaryServiceService {

  wordList: IWord[] = [
    {word: "home", mean: "nhà"},
    {word: "street", mean: "đường"},
    {word: "market", mean: "chợ"},
    {word: "bicycle", mean: "xe đạp"},
    {word: "cook", mean: "nấu"},
  ];

  constructor() { }

  showList() {
    return this.wordList;
  }

  showMeaning(value: string) {
    return this.wordList.find(item => item.word == value);
  }
}
