import {Injectable} from '@angular/core';
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class AlertsService {

  constructor(private toast: ToastrService) {
  }

  showSuccess(body: string, title: string) {
    this.toast.success(body, title)
  }

  showError(body: string, title: string) {
    this.toast.error(body, title)
  }
}
