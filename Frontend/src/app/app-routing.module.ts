import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListComponent} from "./components/list/list.component";
import {CreateContactComponent} from './components/create-contact/create-contact.component';
import {UpdateContactComponent} from './components/update-contact/update-contact.component';

const routes: Routes = [
  {path: 'list', component: ListComponent},
  {path: 'create', component: CreateContactComponent},
  {path: 'update/:id', component: UpdateContactComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
