import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ContactI} from '../../models/contact.interface';
import {ApiService} from "../../services/api/api.service";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {AlertsService} from "../../services/alerts/alerts.service";


@Component({
  selector: 'app-update-contact',
  templateUrl: './update-contact.component.html',
  styleUrls: ['./update-contact.component.css']
})
export class UpdateContactComponent implements OnInit {

  constructor(private activerouter: ActivatedRoute,
              private router: Router,
              private api: ApiService,
              private alertsService: AlertsService) {
  }

  updateForm = new FormGroup({
    namePerson: new FormControl(''),
    phone: new FormControl(''),
    dateBirth: new FormControl(''),
    email: new FormControl(''),

  });

  ngOnInit(): void {
    let contactId = this.activerouter.snapshot.paramMap.get('id')
    this.api.getSingleContact(contactId).subscribe(data => {
      console.log(data)
      this.updateForm.setValue({
        'namePerson': data.namePerson,
        'phone': data.phone,
        'dateBirth': data.dateBirth,
        'email': data.email,
      })
      console.log(this.updateForm.value)
    })
  }

  submitUpdateForm(form: ContactI) {
    let contactId = this.activerouter.snapshot.paramMap.get('id');
    this.api.putContact(contactId, this.updateForm.value)
      .subscribe(data =>
        console.log(data)
      )

    this.router.navigate(['list'])
  }

  hardDelete() {
    let contactId = this.activerouter.snapshot.paramMap.get('id');
    this.api.hardDelete(contactId)
      .subscribe(data => {
      })
    this.router.navigate(['list'])
  }

  goBack() {
    this.router.navigate(['list'])
  }


}
