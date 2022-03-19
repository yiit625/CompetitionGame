import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'competition-game-ui';
  showSelectedPage = false

  solve() {
    console.log("SOLVE")
    this.showSelectedPage = false
  }

  top3() {
    console.log("TOP3")
    this.showSelectedPage = true
  }
}
