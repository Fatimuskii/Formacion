import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-hero-form-reactive',
  templateUrl: './hero-form-reactive.component.html',
  styleUrls: ['./hero-form-reactive.component.css']
})
export class HeroFormReactiveComponent implements OnInit {

  powers = ['Really Smart', 'Super Flexible', 'Weather Changer'];

  hero = { name: 'Dr.', alterEgo: 'Dr. What', power: this.powers[0] };

  heroForm: FormGroup;
  //notValidText = "^[a-z0-9_-]{8,15}$";
  //notValidText= "/^([^0-9]*)$/";
  notValidText = "^[^0-9]+$"
  ngOnInit(): void {
    this.heroForm = new FormGroup({
      name: new FormControl(this.hero.name, [
        Validators.required,
        Validators.minLength(4),
        Validators.pattern(this.notValidText)
        //forbiddenNameValidator(/bob/i)
      ]),
      alterEgo: new FormControl(this.hero.alterEgo, /*{
        asyncValidators: [this.alterEgoValidator.validate.bind(this.alterEgoValidator)],
        updateOn: 'blur'
      }*/ [ Validators.required,
        Validators.minLength(4)
      ]),
      power: new FormControl(this.hero.power, Validators.required)
    }); // <-- add custom validator at the FormGroup level
  }

  get name() { return this.heroForm.get('name'); }

  get power() { return this.heroForm.get('power'); }

  get alterEgo() { return this.heroForm.get('alterEgo'); }

}
