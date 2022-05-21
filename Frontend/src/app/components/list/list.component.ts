import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/api/api.service";
import {Router} from "@angular/router";
import {ContactListInterface} from "../../models/contactList.interface";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  allContacts: ContactListInterface[] = [];

  constructor(private api: ApiService, private router: Router) {
  }

  ngOnInit(): void {
    this.api.getContactList().subscribe(data => {
      console.log(data);
      this.allContacts = data;
    })
  }

  updateContact(id: any) {
    this.router.navigate(['update', id])
  }

  createContact() {
    this.router.navigate(['create'])
  }
}
