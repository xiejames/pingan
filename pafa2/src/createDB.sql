create table policy_jack
(
policyno varchar2(20), 
applicant varchar2(20),
insured varchar2(20),
sumIns  int, 
unit int
);

alter table policy_jack
  add constraint policy_jack_PK primary key (policyno);
  
  commit;
  