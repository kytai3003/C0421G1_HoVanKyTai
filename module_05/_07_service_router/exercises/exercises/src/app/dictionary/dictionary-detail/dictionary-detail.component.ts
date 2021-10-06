import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../../service/dictionary-service.service";
import {IWord} from "../../model/IWord";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  wordDetail: IWord;

  constructor(private dictionaryService: DictionaryServiceService, private activatedRoute: ActivatedRoute) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get("word");
      console.log(word);
      this.wordDetail = dictionaryService.showMeaning(word);
    })
  };

  ngOnInit(): void {
  }



}
