import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { AlertService } from '../services/alert.service';

@Component({
  selector: 'my-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{
    loading = false;
    model: any = {};
    homeUrl:string = '/home/dashboard';

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService ){

    }

    ngOnInit(){
        this.model=JSON.parse(localStorage.getItem('rememberMe'));
    }

    login(): void {
        if (this.model.rememberMe){
            this.rememberMe();
        }

        if(this.authenticationService.login(this.model.username, this.model.password)){
            this.router.navigate([this.homeUrl]);
        } else {
            alert("Username or password invalid!");
        }
    }

    rememberMe(){
        localStorage.setItem('rememberMe', JSON.stringify({ 'username': this.model.username, 'password': this.model.password }))
    }
}