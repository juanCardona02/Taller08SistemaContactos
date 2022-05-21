import { Injectable } from '@angular/core';
import {ContactListInterface} from '../../models/contactList.interface';
import {ResponseI} from '../../models/responseI.interface';
import {Observable} from "rxjs";
import { HttpClient } from "@angular/common/http";
import { ContactI } from '../../models/contact.interface';
import {AlertsService} from "../alerts/alerts.service";

@Injectable()
export class ApiService {

  private readonly url:string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/';
  }

  getContactList():Observable<ContactListInterface[]>{
    return this.http.get<ContactListInterface[]>('http://localhost:8080/contacts');
  }

  getSingleContact(id:any):Observable<ContactListInterface>{
    return this.http.get<ContactListInterface>(this.url+'contact/'+id);
  }

  putContact(id:any, form:ContactI):Observable<ResponseI>{
    console.log(this.url+'contact/'+id, form)
    return this.http.put<ResponseI>(this.url+'contact/'+id, form);
  }

  hardDelete(id:any):Observable<ResponseI>{
    return this.http.delete<ResponseI>(this.url+'contact/'+id);
  }


  postContact(contact:any):Observable<any> {
    return this.http.post<any>(this.url+'contact', contact);
  }
}
