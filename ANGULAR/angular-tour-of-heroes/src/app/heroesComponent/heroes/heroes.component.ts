import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero'; // imports Hero interface
//import { HEROES } from '../mock-heroes'; // imports class of hero's mock-

import { HeroService } from '../../services/heroService/hero.service';

import {MessageService} from '../../services/messageService/message.service'; 

/**@Component is a decorator function that specifies the Angular metadata for the component. */
@Component({
  selector: 'app-heroes', /**the component's CSS element selector */
  templateUrl: './heroes.component.html', /** the location of the component's template file. */
  styleUrls: ['./heroes.component.css'], /**the location of the component's private CSS styles. */
})
export class HeroesComponent implements OnInit {


  //hero = 'Windstorm';
  /* Create a variable of type interface Hero
   hero: Hero ={
    id: 1,
    name: 'Windstorm'
   }*/


  selectedHero?: Hero;
  /*onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }*/
  //Creates a variable with a [] of heros made with a mock
  //heroes = HEROES;
  heroes: Hero[] = [];

  //Inject the HeroService to load mock
  constructor(private heroService: HeroService, private messageService: MessageService) {

  }

  ngOnInit(): void {

    this.getHeroes();
  }


  //Create a method to retrieve the heroes from the service.
  /*getHeroes(): void {

    //The HeroService.getHeroes() method has a synchronous signature, which implies that the HeroService can fetch heroes synchronously. 
    this.heroes = this.heroService.getHeroes();
  }*/

  /* The new version waits for the Observable to emit the array of heroes—which could happen now or several minutes from now. 
  The subscribe() method passes the emitted array to the callback, which sets the component's heroes property. */
  getHeroes(): void {
    this.heroService.getHeroes()
        .subscribe(heroes => this.heroes = heroes);
  }

  /*onSelect(hero: Hero): void {
    this.selectedHero = hero;
    this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
  }*/

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.addHero({ name } as Hero)
      .subscribe(hero => {
        this.heroes.push(hero);
      });
  }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService.deleteHero(hero).subscribe();
  }

}
