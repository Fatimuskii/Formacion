import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroesComponent/heroes/heroes.component';

import {DashboardComponent} from './dashboard/dashboard.component';

import {HeroDetailComponent} from './heroesComponent/hero-detail/hero-detail.component';
/*
path: a string that matches the URL in the browser address bar.
component: the component that the router should create when navigating to this route.
 
This tells the router to match that URL to path: 'heroes' and display the HeroesComponent when the URL is something like localhost:4200/heroes.
*/
const routes: Routes = [
  {path: 'heroes', component: HeroesComponent},
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:id', component: HeroDetailComponent },
];


//The @NgModule metadata initializes the router and starts it listening for browser location changes.
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
