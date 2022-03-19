import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DevUIModule} from "ng-devui";
import { GridPageComponent } from './grid-page/grid-page/grid-page.component';
import { SubmitPageComponent } from './submit-page/submit-page/submit-page.component';

@NgModule({
  declarations: [
    AppComponent,
    GridPageComponent,
    SubmitPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DevUIModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
