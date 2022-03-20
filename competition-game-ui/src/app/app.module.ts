import {NgModule, TemplateRef} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DevUIModule, FormModule} from "ng-devui";
import { GridPageComponent } from './grid-page/grid-page.component';
import { SubmitPageComponent } from './submit-page/submit-page.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AlertModule } from 'ng-devui/alert';
import { DataTableModule } from 'ng-devui/data-table';

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
    DevUIModule,
    FormsModule,
    HttpClientModule,
    AlertModule,
    DataTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
