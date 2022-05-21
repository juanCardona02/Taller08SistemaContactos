import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ApiService} from "../../services/api/api.service";


@Component({
  selector: 'app-create-contact',
  templateUrl: './create-contact.component.html',
  styleUrls: ['./create-contact.component.css']
})
export class CreateContactComponent implements OnInit {
  newContactForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    dateOfBirth: new FormControl(''),
    email: new FormControl(''),
  });

  constructor(private activerouter: ActivatedRoute,
              private router: Router,
              private api: ApiService) {
  }

  ngOnInit(): void {
    this.api.postContact(
      {
        firstName: "j",
        lastName: "j",
        email: "j@j.com",
        dateOfBirth: "2000-02-02"
      }
    ).subscribe(data => console.log(data))
  }

  submitNewContactForm(newContactForm: any) {
    this.api
      .postContact(newContactForm)
      .subscribe(result =>
        console.log(result)
      )
    this.goBack()
  }


  goBack() {
    this.router.navigate(['list'])
  }

}
