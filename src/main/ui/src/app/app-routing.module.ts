import { AdminAssignedComponent } from './components/admin-assigned/admin-assigned.component';
import { NewRegistrationComponent } from './components/new-registration/new-registration.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { UserIncidentlistComponent } from './components/user-incidentlist/user-incidentlist.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardMainBodyComponent } from './components/dashboard-main-body/dashboard-main-body.component';
import { UserIncidentFormComponent } from './components/user-incident-form/user-incident-form.component';
import { UserIncidentformReopenComponent } from './components/user-incidentform-reopen/user-incidentform-reopen.component';
// import { UserIncidentlistComponent } from './user-incidentlist/user-incidentlist.component';
// import { DashboardMainBodyComponent } from './components/dashboard-main-body/dashboard-main-body.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
//import { AdminMainComponent } from "./components/admin-main/admin-main.component";
import { UserGroupComponent } from "./components/user-group/user-group.component";
import { AdminHeaderComponent } from "./components/admin-header/admin-header.component";
import { AccessibilityComponent } from "./components/accessibility/accessibility.component";
import { UserRegistrationComponent } from "./components/user-registration/user-registration.component";
import { AdminCitiesComponent } from "./components/admin-cities/admin-cities.component";
import { AdminCategoriesComponent } from "./components/admin-categories/admin-categories.component";
import { AdminHomeComponent } from "./components/admin-home/admin-home.component";
import { AdminAddnewcitiesComponent } from './components/admin-addnewcities/admin-addnewcities.component';
import { AdminUnassignedComponent } from './components/admin-unassigned/admin-unassigned.component';
import { ResolvedComponent } from './components/resolved/resolved.component';
import { OpenActiveComponent } from './components/open-active/open-active.component';
import { AdminAddnewgroupsComponent } from './components/admin-addnewgroups/admin-addnewgroups.component';
import { AdminAddnewcatagoryComponent } from './components/admin-addnewcatagory/admin-addnewcatagory.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component'; 
// import { UserIncidentformReopenComponent } from './components/user-incidentform-reopen/user-incidentform-reopen.component';
import { AdminResolverComponent } from './components/admin-resolver/admin-resolver.component';



const routes: Routes = [

  {
    path: '',
    component: LoginComponent,
    children: [
      { path: '', component: UserLoginComponent },
      { path: 'user-login', component: UserLoginComponent },
      { path: 'new-registration', component: NewRegistrationComponent }
    ]
  }, {
    path: 'main',
    component: MainComponent,
    children: [
      { path: '', component: DashboardMainBodyComponent },
      { path: 'user-profile', component: UserProfileComponent },
      { path: 'user-incidentform-reopen', component: UserIncidentformReopenComponent },
      { path: 'user-incident-form', component: UserIncidentFormComponent },
      {
        path: 'user-incidentlist', component: UserIncidentlistComponent,
        children: [
          { path: 'user-incident-form', component: UserIncidentFormComponent },
        ]
      }
    ]
  },
  // {
  //   path: 'user-incidentlist',
  //   component: UserIncidentlistComponent,
  //   children:[

  //       { path: 'user-incident-form', redirectTo:'user-incident-form', pathMatch:'full'}
  //     ]
  //   }


  // {
  //   path: 'user-incidentlist',
  //   component: UserIncidentlistComponent,
  // }
  {
    path: 'admin-header',
    component: AdminHeaderComponent,
    children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'admin-dashboard', component: AdminDashboardComponent },
      { path: 'user-incident-form', component: UserIncidentFormComponent },
      {
        path: 'user-group', component: UserGroupComponent,
        children: [{
          path: 'admin-addnewgroups',
          component: AdminAddnewgroupsComponent
        }]
      },
      { path: 'user-registration', component: UserRegistrationComponent },
      { path: 'resolved', component: ResolvedComponent },
      { path: 'admin-categories', component: AdminCategoriesComponent },
       { path: 'open-active', component: OpenActiveComponent },
      { path: 'admin-assigned', component: AdminAssignedComponent },
      { path: 'admin-unassigned', component: AdminUnassignedComponent },
      {
        path: 'admin-catagory', component: AdminCategoriesComponent,
        children: [{
          path: 'admin-addnewcatagory',
          component: AdminAddnewcatagoryComponent
        }]
      },
      { path: 'accessibility', component: AccessibilityComponent },
      {
        path: 'admin-cities',
        component: AdminCitiesComponent,
        children: [{
          path: 'admin-addnewcities',
          component: AdminAddnewcitiesComponent
        }]
      }]
  },
  {
    path: 'admin-header',
    component: AdminHeaderComponent,
    children: [
      {
        path: 'admin-addnewcities',
        component: AdminAddnewcitiesComponent
      },
      {
        path: 'admin-addnewcatagory',
        component: AdminAddnewcatagoryComponent
      },
      {
        path: 'admin-addnewgroups',
        component: AdminAddnewgroupsComponent
      },
      {
        path: 'admin-resolver',
        component: AdminResolverComponent
      }
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
