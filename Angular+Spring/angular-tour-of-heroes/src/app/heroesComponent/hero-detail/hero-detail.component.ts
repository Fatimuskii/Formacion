import { Component, OnInit, Input} from '@angular/core';
import { Hero } from '../hero';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {HeroService} from '../../services/heroService/hero.service';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {


  //Add a hero property, preceded by the @Input() decorator.
  hero?: Hero;


  /*
    The ActivatedRoute holds information about the route to this instance of the HeroDetailComponent. This component is interested in the route's parameters extracted from the URL. The "id" parameter is the id of the hero to display.
    The HeroService gets hero data from the remote server and this component will use it to get the hero-to-display.
    The location is an Angular service for interacting with the browser. You'll use it later to navigate back to the view that navigated here.
  */
  constructor( private route: ActivatedRoute,
    private heroService: HeroService,
    private location: Location) { }

  ngOnInit(): void {
    this.getHero();
  }

  getHero():void{

    //The JavaScript (+) operator converts the string to a number, which is what a hero id should be.
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.heroService.getHero(id)
    .subscribe(hero => this.hero = hero);
  }

  goBack(): void {
    this.location.back();
  }

  save():void{
    this.heroService.updateHero(this.hero)
    .subscribe(() => this.goBack());
  }
}
