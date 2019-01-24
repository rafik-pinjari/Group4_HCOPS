import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import 'hammerjs/hammer';
import { MatExpansionModule } from '@angular/material/expansion';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropDownsModule } from '@progress/kendo-angular-dropdowns';
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { AppRoutingModule } from './app-routing.module';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { ChartsModule } from '@progress/kendo-angular-charts';
import { SparklineModule } from '@progress/kendo-angular-charts';
import { GridModule } from '@progress/kendo-angular-grid';
import { AppComponent } from './app.component';
import { NewRegistrationComponent } from './components/new-registration/new-registration.component';
import { UserIncidentFormComponent } from './components/user-incident-form/user-incident-form.component';
import { UserIncidentlistComponent } from './components/user-incidentlist/user-incidentlist.component';
import { LoginComponent } from './components/login/login.component';
import { UserGroupComponent } from './components/user-group/user-group.component';
import { AdminOverviewComponent } from './components/admin-overview/admin-overview.component';
import { DashboardHeaderComponent } from './components/dashboard-header/dashboard-header.component';
import { DashboardMainBodyComponent } from './components/dashboard-main-body/dashboard-main-body.component';
import { DashboardFooterComponent } from './components/dashboard-footer/dashboard-footer.component';
import { MainComponent } from './components/main/main.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { AccessibilityComponent } from './components/accessibility/accessibility.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminHeaderComponent } from './components/admin-header/admin-header.component';
// import { AdminMainComponent } from './components/admin-main/admin-main.component';
import { AdminCitiesComponent } from './components/admin-cities/admin-cities.component';
import { AdminCategoriesComponent } from './components/admin-categories/admin-categories.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { ResolvedComponent } from './components/resolved/resolved.component';
import { AdminActiveComponent } from './components/admin-active/admin-active.component';
import { AdminAssignedComponent } from './components/admin-assigned/admin-assigned.component';
import { AdminUnassignedComponent } from './components/admin-unassigned/admin-unassigned.component';
// import { AdminResolvedComponent } from './components/admin-resolved/admin-resolved.component';
import { UserIncidentformReopenComponent } from './components/user-incidentform-reopen/user-incidentform-reopen.component';
import { AdminAddnewcitiesComponent } from './components/admin-addnewcities/admin-addnewcities.component';
import { OpenActiveComponent } from './components/open-active/open-active.component';
import {RegisterService} from './providers/register.service';
import {LoginService} from './providers/login.service';
import { LocationserviceService } from './providers/locationservice.service';
import {AddNewUserService} from './providers/add-new-user.service';
import { UserIncidentFormService } from './providers/user-incident-form.service';
import { CategoryserviceService } from './providers/categoryservice.service';
import { HttpXrsService } from './providers/http-xrs.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AdminAddnewgroupsComponent } from './components/admin-addnewgroups/admin-addnewgroups.component';
import { AdminAddnewcatagoryComponent } from './components/admin-addnewcatagory/admin-addnewcatagory.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AdminResolverComponent } from './components/admin-resolver/admin-resolver.component';
import { ProfilepicService } from "./providers/profilepic.service";
import { UserincidentlistService } from "./providers/userincidentlist.service";

import { EditServiceService } from './providers/edit-service.service';


@NgModule({
  declarations: [
    UserProfileComponent,
    UserLoginComponent,
    NewRegistrationComponent,
    AppComponent,
    UserIncidentFormComponent,
    UserIncidentlistComponent,
    UserIncidentformReopenComponent,
    LoginComponent,
    UserGroupComponent,
    AdminOverviewComponent,
    DashboardHeaderComponent,
    DashboardMainBodyComponent,
    DashboardFooterComponent,
    MainComponent,
    UserRegistrationComponent,
    AccessibilityComponent,
    AdminDashboardComponent,
    AdminHeaderComponent,
    // AdminMainComponent,
    AdminCitiesComponent,
    AdminCategoriesComponent,
    AdminHomeComponent,
    ResolvedComponent,
    AdminActiveComponent,
    AdminAssignedComponent,
    AdminAddnewcitiesComponent,
    AdminUnassignedComponent,
    OpenActiveComponent,
    UserLoginComponent,
    NewRegistrationComponent,
    AdminAddnewgroupsComponent,
    AdminAddnewcatagoryComponent,
    UserProfileComponent,
    AdminResolverComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    ChartsModule,
    SparklineModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    GridModule,
    DropDownsModule
  ],
  // providers: [RegisterService,LoginService,UserIncidentFormService,ProfilepicService,CategoryserviceService,LocationserviceService,AddNewUserService,UserincidentlistService],
  
  providers: [RegisterService,
    LoginService,
    UserIncidentFormService,
    HttpXrsService, UserIncidentFormService,
    ProfilepicService, CategoryserviceService,ProfilepicService,
    LocationserviceService, AddNewUserService,UserincidentlistService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
